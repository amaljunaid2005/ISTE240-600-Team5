package org.example.project.controllers;

import org.example.project.models.Review;
import org.example.project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // GET: Get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviewList = reviewService.getAllReviews();
        return new ResponseEntity<>(reviewList, HttpStatus.OK); // Return reviews as JSON
    }

    // GET: Get a review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK); // Return review as JSON
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 if not found
        }
    }

}