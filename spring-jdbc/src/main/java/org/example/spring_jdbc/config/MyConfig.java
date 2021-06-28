package org.example.spring_jdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"org.example"})
public class MyConfig {


	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

}