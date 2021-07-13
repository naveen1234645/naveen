package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IssueNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

}