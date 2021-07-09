package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private Environment environment;
	
	@Autowired
	public HelloWorldController(Environment environment) {
		this.environment = environment;
	}


	@GetMapping("/")
	public String sayHello()
	{
		return "hello-world apploication is running on port number: "+environment.getProperty("local.server.port");
	}

}