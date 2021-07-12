package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7813167605939212119L;
	private String message;
	
	

}