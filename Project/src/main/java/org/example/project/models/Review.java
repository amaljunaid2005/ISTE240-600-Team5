package org.example.project.models;

import jakarta.persistence.*;

import java.time.LocalDate;

/*
 * Represents a review written by a user for a movie.
 * The review includes the following: unique id, rating, text, and the date it was created.
 */
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String reviewText;

    @Column(nullable = false )
    private int rating; // Rating given by the user (1–10)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(nullable = false)
    private LocalDate reviewDate = LocalDate.now(); // auto-set today

    public Review(){
    }

    public Review(String reviewText, int rating, UserProfile userProfile, Movie movie) {
        this.reviewText = reviewText;
        this.rating = rating;
        this.userProfile = userProfile;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 1 and 10");
        }
        this.rating = rating;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}