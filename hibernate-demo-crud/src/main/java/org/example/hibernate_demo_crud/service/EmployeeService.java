package org.example.hibernate_demo_crud.service;



import java.util.List;

import org.example.hibernate_demo_crud.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public List<Employee> displayAllEmployee();
	public Employee getemployeeById(Integer id);
	public Employee updateEmployee(Integer id);
	public void deleteEmployee(Integer id);

}
