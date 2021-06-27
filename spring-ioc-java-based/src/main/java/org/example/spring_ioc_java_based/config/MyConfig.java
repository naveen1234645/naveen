package org.example.spring_ioc_java_based.config;

import java.util.ArrayList;

import org.example.spring_ioc_java_based.pojo.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.example" })
public class MyConfig {
	
	@Bean
	public ArrayList<Account> list()
	{
		return new ArrayList<Account>();
	}

}