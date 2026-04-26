package org.example.project.model;

import java.time.LocalDate;

/*
 * Represents a review written by a user for a movie.
 * The review includes the following: unique id, rating, text, and the date it was created.
 */
public class Review {

    private int id;
    private String reviewText;
    private int rating; // Rating given by the user (1–10)
    private UserProfile userProfile;
    private Movie movie;
    private LocalDate reviewDate = LocalDate.now(); // auto-set today

    public Review(){
    }

    public Review(int id, String reviewText, int rating, UserProfile userProfile, Movie movie) {
        this.id = id;
        this.reviewText = reviewText;
        this.rating = rating;
        this.userProfile = userProfile;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
