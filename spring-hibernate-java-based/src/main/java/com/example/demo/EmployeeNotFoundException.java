package com.example.demo;

public class EmployeeNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -5393531778601000053L;
	private String message;
	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	
	
}
