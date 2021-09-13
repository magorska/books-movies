package com.booksmovies.backend.service;

import com.booksmovies.backend.domain.Review;
import com.vaadin.flow.data.binder.Binder;

import java.util.HashSet;
import java.util.Set;

import static com.vaadin.flow.data.binder.Binder.setVisible;

public class ReviewService {

    private Set reviews;
    private static ReviewService reviewService;
    private Binder<Review> binder = new Binder<Review>(Review.class);


    private ReviewService() {
        this.reviews = exampleData();
    }

    public static ReviewService getInstance() {
        if (reviewService == null) {
            reviewService = new ReviewService();
        }
        return reviewService;
    }

    public Set getReviews() {
        return new HashSet<>(reviews);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    private Set exampleData() {
        Set reviews = new HashSet<>();
        reviews.add(new Review(5, "It was good"));
        reviews.add(new Review(2, "Boring"));
        reviews.add(new Review(9, "Excellent!"));
        return reviews;
    }

    public void save(Review review) {
        this.reviews.add(review);
    }

    public void delete(Review review) {
        this.reviews.remove(review);
    }

    public void setReviews(Review review) {
        binder.setBean(review);

        if (review == null) {
            setVisible(false);
        } else {
            setVisible(true);
            title.focus();
        }
    }
}