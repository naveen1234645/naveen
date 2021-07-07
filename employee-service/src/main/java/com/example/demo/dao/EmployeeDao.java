package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeDao {

	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Integer id);
	public Employee getByEmployeeId(String id);
	public List<Employee> getByFirstName(String firstName);
	public List<Employee> getByLastName(String lastName);
	public Employee updateByEmployeeId(String employeeId, Employee employee);
	public String deleteByEmployeeId(String employeeId);
}