package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Book;

@Configuration
public class MyConfig {

	
	@Bean
	public Map<Integer, Book> bookMap()
	{
		return new HashMap<Integer, Book>();
	}
}