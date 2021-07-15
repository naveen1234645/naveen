package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	@Column(name = "movie_name",unique = true)
	private String movieName;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@JsonProperty
	private Boolean isAvailable;
	public Movie(String movieName, Genre genre, Boolean isAvailable) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.isAvailable = isAvailable;
	}

}