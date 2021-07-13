package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	
	private Environment environment;

	@Autowired
	public OrderController(Environment environment) {
		this.environment = environment;
	}
	@GetMapping
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("app running and up on port"+environment.getProperty("local.server.port"));
	}
}