package com.booksmovies.ui;

import com.booksmovies.backend.domain.Review;
import com.booksmovies.backend.service.ReviewService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/1/reviews")
public class ReviewView extends VerticalLayout {

    private ReviewService reviewService = ReviewService.getInstance();
    private Grid<Review> grid = new Grid<>(Review.class);

    public ReviewView() {
        grid.setColumns("You rate", "Your review", "Book or movie title");
        add(grid);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(reviewService.getReviews());
    }
}
