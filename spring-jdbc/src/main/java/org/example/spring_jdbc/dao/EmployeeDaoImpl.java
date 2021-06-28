package org.example.spring_jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.example.spring_jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;

	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Employee createEmployee(Employee employee) {

		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into employee(id,first_name,last_name,email) values(?,?,?,?)");
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> displayEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
