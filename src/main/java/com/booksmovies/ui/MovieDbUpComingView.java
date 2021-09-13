package com.booksmovies.ui;

import com.booksmovies.backend.domain.MovieDbClient;
import com.booksmovies.backend.service.MovieDbClientService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/v1/movieDb/upcoming")
public class MovieDbUpComingView extends VerticalLayout {

    private MovieDbClientService movieDbClientService = MovieDbClientService.getInstance();
    private Grid<MovieDbClient> grid = new Grid<>(MovieDbClient.class);

    public MovieDbUpComingView() {
        grid.setColumns("Title", "Overview", "Publication year", "Vote average");
        add(grid);
        setSizeFull();
        refresh();
    }
    public void refresh() {
        grid.setItems(movieDbClientService.getUpComing());
    }
}
