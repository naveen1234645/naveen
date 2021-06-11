package org.example.app;

public class InvalidPriceException extends RuntimeException {

	private String message;

	public InvalidPriceException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}



}
