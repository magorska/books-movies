package com.booksmovies.backend.service;

import com.booksmovies.backend.domain.MovieDbClient;

import java.util.HashSet;
import java.util.Set;

public class MovieDbClientService {

    private Set movies;
    private static MovieDbClientService movieDbClientService;

    private MovieDbClientService() {
        this.movies = exampleData();
    }

    public static MovieDbClientService getInstance() {
        if (movieDbClientService == null) {
            movieDbClientService = new MovieDbClientService();
        }
        return movieDbClientService;
    }

    public Set getSearchList() {
        return new HashSet<>(movies);
    }

    public MovieDbClient getLatest(MovieDbClient movie) {
        return new MovieDbClient(movie);
    }

    public Set getUpComing() {
        return new HashSet<>(movies);
    }

    public Set getTopRated() {
        return new HashSet<>(movies);
    }

    public Set getDayTrending() {
        return new HashSet<>(movies);
    }

    public Set getWeekTrending() {
        return new HashSet<>(movies);
    }

    private Set exampleData() {
        Set movies = new HashSet<>();
        movies.add(new MovieDbClient("LoTR: The Fellowship of the ring", "Peter Jackson", "09-2001", 7.8));
        movies.add(new MovieDbClient("LoTR: Two towers", "Peter Jackson", "11-2002", 8.2));
        movies.add(new MovieDbClient("LoTR: Return of the King", "Peter Jackson", "12-2003", 9));
        return movies;
    }

}
