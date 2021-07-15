package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.MovieRepository;
import com.example.demo.model.Genre;
import com.example.demo.model.Movie;

@SpringBootApplication
@EnableEurekaClient
public class MovieServiceAppApplication implements CommandLineRunner{

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceAppApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Movie> list=new ArrayList<Movie>();
		list.add(new Movie("Movie-A", Genre.BIOGRAPHY, true));
		list.add(new Movie("Movie-B", Genre.HOROR, true));
		list.add(new Movie("Movie-C", Genre.TRHILLER, false));
		list.add(new Movie("Movie-D", Genre.BIOGRAPHY, false));
		list.add(new Movie("Movie-E", Genre.TRHILLER, true));
		movieRepository.saveAll(list);
		
	}

}