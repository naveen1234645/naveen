package com.example.demo;



import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3307411853358267214L;
	private String message;
	
	

}