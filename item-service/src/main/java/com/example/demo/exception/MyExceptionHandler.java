package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.ui.ItemErrorResponseModel;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ItemErrorResponseModel> handleItemNotFoundException(ItemNotFoundException e)
	{
		ItemErrorResponseModel error=new ItemErrorResponseModel();
		error.setMessage(e.getMessage());
		error.setErrprReportingTime(System.currentTimeMillis());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}