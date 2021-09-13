package com.booksmovies.backend.domain;


import java.util.Objects;

public class MovieDbClient {

    private String title;
    private String overview;
    private String releaseDate;
    private double voteAverage;

    public MovieDbClient(String title, String overview, String releaseDate, double voteAverage) {
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
    }

    public MovieDbClient(MovieDbClient movie) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDbClient that = (MovieDbClient) o;
        return Double.compare(that.voteAverage, voteAverage) == 0 && Objects.equals(title, that.title) && Objects.equals(overview, that.overview) && Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, overview, releaseDate, voteAverage);
    }
}
