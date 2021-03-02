package com.shopping.moviedetail.model;

public class MovieDetails {

    private String movieId;
    private String movieName;

    public MovieDetails(String movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public MovieDetails() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
