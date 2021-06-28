package org.example.spring_jdbc.dao;


import java.util.List;

import org.example.spring_jdbc.model.Employee;

public interface EmployeeDao {

	public Employee createEmployee(Employee employee);
	public List<Employee> displayEmployees();

}