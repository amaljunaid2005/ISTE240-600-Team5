// Done by Mehrin Fathima - 418006818
package org.example.project.controllers;

import jakarta.persistence.EntityNotFoundException;
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

    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviewList = reviewService.getAllReviews();
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Review>> searchReviews(@RequestParam String reviewText) {
        List<Review> results = reviewService.searchByReviewText(reviewText);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        try {
            Review savedReview = reviewService.saveReview(review);

            System.out.println("POST HIT");
            System.out.println(review);

            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(
            @PathVariable Long id,
            @RequestBody Review review) {
        try {
            Review updatedReview = reviewService.updateReview(id, review);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        try {
            reviewService.deleteReviewById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
