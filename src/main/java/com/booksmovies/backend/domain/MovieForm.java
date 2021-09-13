package com.booksmovies.backend.domain;

import com.booksmovies.backend.service.MovieService;
import com.booksmovies.ui.MovieView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class MovieForm {

    private TextField title = new TextField("Title");
    private TextField director = new TextField("Director");
    private TextField publicationYear = new TextField("Publication year");

    private MovieView movieView;
    private MovieService service = MovieService.getInstance();

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Movie> binder = new Binder<Movie>(Movie.class);

    public MovieForm() {
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        binder.bindInstanceFields(this);
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
        add(title, director, publicationYear, buttons);
    }

    public MovieForm(MovieView movieView) {
        this.movieView = movieView;
    }

    private void save() {
        Movie movie = binder.getBean();
        service.save(movie);
        movieView.refresh();
        setMovie(null);
    }

    private void delete() {
        Movie movie = binder.getBean();
        service.delete(movie);
        movieView.refresh();
        setMovie(null);
    }
}
