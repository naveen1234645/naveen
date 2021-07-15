package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieClient {
	
	@GetMapping("/movies/{movieName}")
	public Movie getMovieByMovieName(@PathVariable("movieName") String movieName);

}