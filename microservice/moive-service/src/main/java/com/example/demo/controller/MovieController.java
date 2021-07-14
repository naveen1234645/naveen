package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovieEntity;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private Environment environment;
	private MovieService movieService;

	@Autowired
	public MovieController(Environment environment,MovieService movieService) {
		this.environment = environment;
		this.movieService=movieService;
	}

	@GetMapping
	public ResponseEntity<String> getStatus() {
		return ResponseEntity.ok("app running and up on port" + environment.getProperty("local.server.port"));
	}
	@PostMapping("/movies")
	public ResponseEntity<MovieEntity> createMovie(@RequestBody MovieEntity movieEntity)
	{
		return new ResponseEntity<MovieEntity>(movieService.createMovie(movieEntity),HttpStatus.CREATED);
	}
	
	@GetMapping("/movies")
	public ResponseEntity<List<MovieEntity>> displayMovies()
	{
		return ResponseEntity.ok(movieService.displayMovies());
	}
}

