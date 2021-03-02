package com.shopping.moviecatelog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shopping.moviecatelog.model.MovieDetails;
import com.shopping.moviecatelog.model.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDetailService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackForMovieDetail")
    public MovieDetails getMovieDetails(MovieRating movieRating) {
        return restTemplate.getForObject("http://movie-detail-service/moviedetails/" + movieRating.getMovieId(), MovieDetails.class);
    }

    private MovieDetails getFallBackForMovieDetail(MovieRating movieRating) {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovieName("NA");
        return movieDetails;

    }
}
