package org.example.project.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;



/*
 * Represents a review written by a user for a movie.
 * The review includes the following: unique id, rating, text, and the date it was created.
 */
public class Review {

    private int id;
    private String reviewText;
    private int rating; // Rating given by the user (1–5)
    private UserProfile userProfile;
    private Movie movie;
    private LocalDate reviewDate;

    public Review(Movie movie, UserProfile userProfile) {
        this.movie = movie;
        this.userProfile = userProfile;
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
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public int getUserProfile() {
        return userProfile.getUserID();
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public int getMovie() {
        return movie.getId();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getUserId(){
        return userProfile.getUserID();
    }

    public int getMovieId(){
        return movie.getId();
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}