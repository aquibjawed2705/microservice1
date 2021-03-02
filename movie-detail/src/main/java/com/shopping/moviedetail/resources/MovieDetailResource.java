package com.shopping.moviedetail.resources;

import com.shopping.moviedetail.model.MovieDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/moviedetails")
public class MovieDetailResource {

    @RequestMapping("{movieId}")
    public MovieDetails getMovieDetails(@PathVariable("movieId") String movieId) {
        Map<String, String> movieList = new HashMap();
        movieList.put("a", "DDLJ");
        movieList.put("b", "KKKG");
        movieList.put("c", "RHTDM");
        movieList.put("d", "TZP");
        movieList.put("e", "3 idiots");
        movieList.put("f", "MPKDH");

        String getMovieName = movieList.get(movieId);
        MovieDetails movieDetails = null;
        if (getMovieName != null) {
            movieDetails = new MovieDetails(movieId, getMovieName);
        } else {
            movieDetails = new MovieDetails(movieId, "ABCD");
        }
        return movieDetails;

    }
}
