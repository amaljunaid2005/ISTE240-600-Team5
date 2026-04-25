package org.example.project.services;

import jakarta.transaction.Transactional;
import org.example.project.dataLayer.ReviewRepository;
import org.example.project.models.Movie;
import org.example.project.models.Review;
import org.example.project.models.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {
    ReviewRepository reviewRepository;

    public Review saveReview(Review reviewToSave){

        Review existingReview = reviewRepository.findByMovieAndUserProfile(reviewToSave.getMovie(), reviewToSave.getUserProfile()).orElse(null);
        if (existingReview != null) {
            throw new IllegalArgumentException("You have already reviewed this movie.");
        }

        Review newReview = new Review();
        newReview.setReviewText(reviewToSave.getReviewText());
        newReview.setUserProfile(reviewToSave.getUserProfile());
        newReview.setMovie(reviewToSave.getMovie());
        newReview.setRating(reviewToSave.getRating());
        newReview.setReviewDate(reviewToSave.getReviewDate());

        return reviewRepository.save(newReview);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById (Long id) {
        return reviewRepository.findById(id);
    }

    public Optional<Review> getReviewByMovieAndUserProfile (Movie movie, UserProfile userProfile) {
        return reviewRepository.findByMovieAndUserProfile(movie,userProfile);
    }

    public void deleteReviewById (Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new IllegalArgumentException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    public void deleteReviewByUserProfileAndMovie (UserProfile userProfile, Movie movie){
        if (!reviewRepository.existsByUserProfileAndMovie(userProfile, movie) ) {
            throw new IllegalArgumentException("Review not found");
        }
        reviewRepository.deleteByUserProfileAndMovie(userProfile, movie);
    }

    public Review updateReview(Long id, Review reviewToUpdate){

        // Check if the review exists
        Review existingReview = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found for the provided ID"));

        existingReview.setReviewText(reviewToUpdate.getReviewText());
        existingReview.setRating(reviewToUpdate.getRating());
        existingReview.setUserProfile(reviewToUpdate.getUserProfile());
        existingReview.setMovie(reviewToUpdate.getMovie());

        return reviewRepository.save(existingReview);
    }
}
