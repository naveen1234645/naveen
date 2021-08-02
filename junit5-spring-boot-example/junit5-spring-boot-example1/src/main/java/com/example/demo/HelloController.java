package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/about")
	public String aboutMe() {
		return "JUnit 5 and Spring Boot Example.";
	}
	@GetMapping("/person")
	public Person getPerson()
	{
		return new Person(1,"John");
	}

}
