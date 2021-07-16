package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.model.RentEntity;
import com.example.demo.proxy.MovieClient;
import com.example.demo.service.RentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RentController {

	
	private RentService rentService;
	private MovieClient movieClient;
	@Autowired
	public RentController(RentService rentService, MovieClient movieClient) {
		this.rentService = rentService;
		this.movieClient = movieClient;
	}
	@PostMapping("/rents")
	public ResponseEntity<RentEntity> createRent(@RequestBody RentEntity rentEntity) throws Exception
	{
		Movie movie=movieClient.getMovieByMovieName(rentEntity.getMovieName());
		if(movie.getIsAvailable()==false)
		{
			throw new Exception();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(rentService.createRent(rentEntity));
	}
	@GetMapping("/rents")
	@HystrixCommand(fallbackMethod = "movieFallBack")
	public ResponseEntity<List<Movie>> getAllMoviesFromMovieService()
	{
		List<Movie> list=movieClient.getMoviesFromMovieService();
		System.out.println(list);
		return ResponseEntity.ok(list);
	}
	
	public ResponseEntity<List<Movie>> movieFallBack()
	{
		List<Movie> list=new ArrayList<Movie>();
		list.add(new Movie(0, "NOT_AVALABLE", null, null));
		return ResponseEntity.ok(list);
	}
}