package org.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {


	private Connection connection;
	private static MyConnectionFactory factory;

	private MyConnectionFactory() throws SQLException
	{
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
	}


	public static MyConnectionFactory createFactory() throws SQLException
	{
		if(factory==null)
		{
			factory=new MyConnectionFactory();
		}
		return factory;
	}

	public Connection getMyConnection()
	{
		return connection;
	}



}