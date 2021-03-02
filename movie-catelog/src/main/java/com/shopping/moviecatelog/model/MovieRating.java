package com.shopping.moviecatelog.model;

public class MovieRating
{

    private String movieId;
    private String userId;
    private String rating;

    public MovieRating(String userId, String movieId, String rating) {
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
    }

    public MovieRating() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
