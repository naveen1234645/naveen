package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookErrorResponse {
	
	private String message;
	private int statusCode;
	private Long errorReportingTime;

}
