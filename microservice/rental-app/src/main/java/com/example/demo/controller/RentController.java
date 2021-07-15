package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.model.RentEntity;
import com.example.demo.proxy.MovieClient;
import com.example.demo.service.RentService;

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
	
	
}