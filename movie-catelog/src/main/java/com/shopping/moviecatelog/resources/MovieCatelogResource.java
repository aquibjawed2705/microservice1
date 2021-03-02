package com.shopping.moviecatelog.resources;

import com.shopping.moviecatelog.model.*;
import com.shopping.moviecatelog.service.MovieDetailService;
import com.shopping.moviecatelog.service.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movieCatelog")
public class MovieCatelogResource {
    @Autowired
    MovieRatingService movieRatingService;
    @Autowired
    MovieDetailService movieDetailService;

    @RequestMapping("{userId}")
    public MovieCatelog getMovieCatelog(@PathVariable("userId") String userId) {
        MovieCatelog movieCatelog = new MovieCatelog();
        List<MovieWatched> movieWatchedList = new ArrayList<>();
        MovieRatings movieRatings = movieRatingService.getMovieRatings(userId);
        if(movieRatings.getMovieRatingList()!=null) {
            for (MovieRating movieRating : movieRatings.getMovieRatingList()) {
                MovieDetails movieDetails = movieDetailService.getMovieDetails(movieRating);
                MovieWatched movieWatched = new MovieWatched();
                movieWatched.setMovieName(movieDetails.getMovieName());
                movieWatched.setMovieRating(movieRating.getRating());
                movieWatched.setMovieId(movieRating.getMovieId());
                movieWatchedList.add(movieWatched);
            }
        }
        movieCatelog.setUserId(userId);
        movieCatelog.setMoviesList(movieWatchedList);
        return movieCatelog;
    }
}
