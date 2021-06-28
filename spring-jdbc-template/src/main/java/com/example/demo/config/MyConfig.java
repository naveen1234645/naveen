package com.example.demo.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = {"com.example"})
@PropertySource(ignoreResourceNotFound = false,value = "classpath:dataSource.properties")
public class MyConfig {
	
	private Environment environment;

	@Autowired
	public MyConfig(Environment environment) {
		super();
		this.environment = environment;
	}
	
	@Bean
	public DataSource dataSource()
	{
		ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
		comboPooledDataSource.setMinPoolSize(5);
		comboPooledDataSource.setMaxPoolSize(20);
		comboPooledDataSource.setInitialPoolSize(2);
		
		return comboPooledDataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource());
	}
	
	

}