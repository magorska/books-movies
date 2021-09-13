package com.booksmovies.backend.domain;

import java.util.Objects;

public class Review {

    private int rating;
    private String review;

    public Review() {
    }

    public Review(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return rating == review1.rating && Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, review);
    }

}
