package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<IssueErrorResponse> handleIssueNotFoundException(IssueNotFoundException e)
	{
		IssueErrorResponse response=new IssueErrorResponse();
		response.setErrorMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<IssueErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<IssueErrorResponse> handleGenericException(Exception e)
	{
		IssueErrorResponse response=new IssueErrorResponse();
		response.setErrorMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<IssueErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
}