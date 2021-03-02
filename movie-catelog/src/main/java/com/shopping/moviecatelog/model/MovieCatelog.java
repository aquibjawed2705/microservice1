package com.shopping.moviecatelog.model;

import java.util.List;

public class MovieCatelog {
    private String userId;
    private List<MovieWatched> moviesList;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<MovieWatched> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<MovieWatched> moviesList) {
        this.moviesList = moviesList;
    }
}
