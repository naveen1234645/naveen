package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.entity.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = {"com.example"})
@EnableTransactionManagement

public class ApplicationConfig {
	
	@Bean
	public DataSource dataSource()
	{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setMinPoolSize(5);
		dataSource.setMinPoolSize(20);
		dataSource.setMaxIdleTime(30000);
		return dataSource;
	}
	
	@Bean
	@Autowired
	public SessionFactory sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernetPropoerties());
		builder.addAnnotatedClass(Employee.class);
		return builder.buildSessionFactory();
	}

	private Properties getHibernetPropoerties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.current_session_context_class", "thread");
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager  hibernateTransactionManager (SessionFactory sessionFactory )
	{
		HibernateTransactionManager manager=new HibernateTransactionManager(sessionFactory);
		
		return manager;
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}