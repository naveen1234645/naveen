package org.example.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.example.factory.MyConnectionFactory;
import org.example.model.Employee;

import com.mysql.cj.xdevapi.Result;

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> list;
	private MyConnectionFactory myConnectionFactory;
	private Connection connection;
	
	
	
	public EmployeeDaoImpl() throws SQLException {
		
		myConnectionFactory=MyConnectionFactory.createFactory();
		connection=myConnectionFactory.getMyConnection();
	}
	@Override
	public Employee createEmployee(Employee employee)throws SQLException {
		
		PreparedStatement preparedStatement=connection.
				prepareStatement
				("insert into employee(id,first_name,last_name,email) values(?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getEmail());
		int result=preparedStatement.executeUpdate();
		System.out.println(result +"rows added");
		return employee;
	}
	@Override
	public List<Employee> getAllEmployees() throws SQLException{
		list=new ArrayList<Employee>();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from employee");
		
		while(resultSet.next())
		{
			list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
					resultSet.getString(4)));
		}
		
		return list;
	}

	@Override
	public List<Employee> findById(Integer id)throws SQLException {
		list=new ArrayList<Employee>();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where id=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));

		}

		return list;
	}

}