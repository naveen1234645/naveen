package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MovieEntity;

public interface MovieService {
	
	public MovieEntity createMovie(MovieEntity movieEntity);
	
	public List<MovieEntity> displayMovies();

}