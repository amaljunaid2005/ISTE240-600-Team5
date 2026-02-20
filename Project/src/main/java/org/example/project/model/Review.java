package org.example.project.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

/*
 * Represents a review written by a user for a movie.
 * The review includes the following: unique id, rating, text, and the date it was created.
 */
public class Review {

    private int id;
    private String reviewText;
    private int rating; // Rating given by the user (1–5)
    private int userId;
    private int movieId;
    private LocalDate reviewDate;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
