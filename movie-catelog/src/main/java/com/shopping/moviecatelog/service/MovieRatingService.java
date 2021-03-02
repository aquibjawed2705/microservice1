package com.shopping.moviecatelog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shopping.moviecatelog.model.MovieRating;
import com.shopping.moviecatelog.model.MovieRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MovieRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackForMovieRatings")
    public MovieRatings getMovieRatings(String userId) {
        return restTemplate.getForObject("http://movie-rating-service/movieratings/" + userId, com.shopping.moviecatelog.model.MovieRatings.class);
    }

    public MovieRatings getFallBackForMovieRatings(String userId)
    {
        MovieRatings movieRatings = new MovieRatings();
        MovieRating movieRating=new MovieRating();
        movieRating.setUserId(userId);
        movieRatings.setMovieRatingList(Arrays.asList(movieRating));
        return  movieRatings;

    }
}
