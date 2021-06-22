package org.example.demo.model;

public enum AccountType {
	SAVINGS("Savings Account"), CREDIT_CARD("Credit Card Account"), LOAN("Loan Account"), CURRENT("Current Account");
	private String message;

	private AccountType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}




}