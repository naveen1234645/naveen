package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -4131122211447736684L;
	private String message;
	public EmployeeNotFoundException(String message) {


		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
