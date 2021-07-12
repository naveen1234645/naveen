package com.example.demo.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ItemErrorResponseModel {
	
	private String message;
	private Integer statusCode;
	private Long errprReportingTime;

}