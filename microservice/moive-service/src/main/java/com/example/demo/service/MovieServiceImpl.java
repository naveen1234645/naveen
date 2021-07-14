package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.MovieRepository;
import com.example.demo.model.MovieEntity;
@Service
public class MovieServiceImpl implements MovieService {


	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository orderRepository) {
		this.movieRepository = movieRepository;
	}
	@Override
	public MovieEntity createMovie(MovieEntity movieEntity) {
		movieRepository.insert(movieEntity);
		return movieEntity;
	}

	@Override
	public List<MovieEntity> displayMovies() {
		
		return movieRepository.findAll();
	}


}
	
	