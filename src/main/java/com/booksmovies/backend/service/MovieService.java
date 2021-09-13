package com.booksmovies.backend.service;

import com.booksmovies.backend.domain.Movie;
import com.vaadin.flow.data.binder.Binder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.vaadin.flow.data.binder.Binder.setVisible;

public class MovieService {

    private Set movies;
    private static MovieService movieService;
    private Binder<Movie> binder = new Binder<Movie>(Movie.class);

    private MovieService() {
        this.movies = exampleData();
    }

    public static MovieService getInstance() {
        if (movieService == null) {
            movieService = new MovieService();
        }
        return movieService;
    }

    public Set getMovies() {
        return new HashSet<>(movies);
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    private Set exampleData() {
        Set movies = new HashSet<>();
        movies.add(new Movie("LoTR: The Fellowship of the ring", "Peter Jackson", 2001));
        movies.add(new Movie("LoTR: Two towers", "Peter Jackson", 2002));
        movies.add(new Movie("LoTR: Return of the King", "Peter Jackson", 2003));
    return movies;
    }

    public Set findByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle.contains(title))
                .collect(Collectors.toSet());
    }

    public void save(Movie movie) {
        this.movies.add(movie);
    }

    public void delete(Movie movie) {
        this.movies.remove(movie);
    }

    public void setMovie(Movie movie) {
        binder.setBean(movie);

        if (movie == null) {
            setVisible(false);
        } else {
            setVisible(true);
            title.focus();
        }
    }
}
