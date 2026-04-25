package org.example.project.dataLayer;

import org.example.project.models.Movie;
import org.example.project.models.Review;
import org.example.project.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Optional<Review> findByMovieAndUserProfile (Movie movie, UserProfile userProfile);

    List<Review> findByMovie(Movie movie);

    List<Review> findByUserProfile(UserProfile userProfile);

    List<Review> findByRating(int rating);

    List<Review> findByRatingBetween(int minRating, int maxRating);

    List<Review> findByReviewDate (LocalDate reviewDate);

    List<Review> findByReviewDateBefore (LocalDate reviewDate);

    List<Review> findByReviewDateAfter (LocalDate reviewDate);

    List<Review> findByReviewDateBetween (LocalDate startDate, LocalDate endDate);

    @Modifying
    @Query("DELETE FROM Review r WHERE r.userProfile = :userProfile AND r.movie = :movie")
    Optional<Review> deleteByUserProfileAndMovie(@Param("userProfile") UserProfile userProfile, @Param("movie") Movie movie);


}
