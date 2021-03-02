package com.shopping.movierating.resources;

import com.shopping.movierating.model.MovieRating;
import com.shopping.movierating.model.MovieRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movieratings")
public class MovieRatingResource {

    @RequestMapping("{userId}")
    public MovieRatings getMovieRating(@PathVariable("userId") String userId) {
        Map<String, List<MovieRating>> movieRatingMap = new HashMap<>();

        movieRatingMap.put("a", Arrays.asList(new MovieRating("a", "a", "4.0"),
                new MovieRating("a", "b", "3.0")
                , new MovieRating("a", "c", "4.2")));

        movieRatingMap.put("b", Arrays.asList(new MovieRating("b", "a", "3.5"),
                new MovieRating("b", "d", "3.8")
                , new MovieRating("b", "c", "4.0")));
        List<MovieRating> movieRatingList = movieRatingMap.get(userId);
        MovieRatings movieRatings = new MovieRatings();
        if (movieRatingList==null) {
            movieRatings.setMovieRatingList(Arrays.asList(new MovieRating(userId, "a", "3.0"),
                    new MovieRating(userId, "b", "2.0")
                    , new MovieRating(userId, "c", "4.0")));
        } else {
            movieRatings.setMovieRatingList(movieRatingList);
        }
        return movieRatings;
    }
}
