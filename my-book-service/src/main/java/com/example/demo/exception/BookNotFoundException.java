package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3150816611453843183L;
	
	private String message;

}
