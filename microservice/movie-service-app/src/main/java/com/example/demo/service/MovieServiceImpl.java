package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MovieRepository;
import com.example.demo.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}


	@Override
	public Movie findByMovieName(String movieName) {
		Movie movie=movieRepository.findByMovieName(movieName);
		return movie;
	}

}