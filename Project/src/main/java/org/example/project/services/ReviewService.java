package org.example.project.services;

import jakarta.transaction.Transactional;
import org.example.project.dataLayer.ReviewRepository;
import org.example.project.models.Movie;
import org.example.project.models.Review;
import org.example.project.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview(Review reviewToSave) {

        // Only check for duplicates if both movie and user are specified
        if (reviewToSave.getMovie() != null && reviewToSave.getUserProfile() != null) {
            Review existingReview = reviewRepository
                    .findByMovieAndUserProfile(
                            reviewToSave.getMovie(),
                            reviewToSave.getUserProfile()
                    ).orElse(null);

            if (existingReview != null) {
                return existingReview;
            }
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

    public double getAverageRatingForMovie(Movie movie) {
        List<Review> reviews = reviewRepository.findByMovie(movie);
        if (reviews.isEmpty()) {
            return 0; // Case where there are no reviews
        }

        double totalRating = reviews.stream().mapToInt(Review::getRating).sum();
        return totalRating / reviews.size();
    }

    public List<Review> getReviewsByMovie(Movie movie) {
        return reviewRepository.findByMovie(movie);
    }

    public List<Review> getReviewsByUserProfile(UserProfile userProfile) {
        return reviewRepository.findByUserProfile(userProfile);
    }

    public List<Review> searchByReviewText(String reviewText) {
        return reviewRepository.findByReviewTextContainingIgnoreCase(reviewText);
    }

    public long countReviewsForMovie(Movie movie) {
        return reviewRepository.countByMovie(movie);
    }

    public void deleteReviewById (Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new IllegalArgumentException("Review not found");
        }
        reviewRepository.deleteById(id);
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
