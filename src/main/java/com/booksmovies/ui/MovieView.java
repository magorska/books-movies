package com.booksmovies.ui;

import com.booksmovies.backend.domain.Movie;
import com.booksmovies.backend.domain.MovieForm;
import com.booksmovies.backend.service.MovieService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("/v1/movies")
public class MovieView extends VerticalLayout {

    private MovieService movieService = MovieService.getInstance();
    private Grid<Movie> grid = new Grid<>(Movie.class);
    private TextField filter = new TextField();
    private MovieForm form = new MovieForm(this);
    private Button addNewMovie = new Button("Add new book");

    public MovieView() {
        filter.setPlaceholder("Filter by title...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("title", "director", "publicationYear");

        addNewMovie.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setMovie(new Movie());
        });
        HorizontalLayout toolbar = new HorizontalLayout(filter, addNewMovie);

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        form.setMovie(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> form.setMovie(grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(movieService.getMovies());
    }

    private void update() {
        grid.setItems(movieService.findByTitle(filter.getValue()));
    }
}
