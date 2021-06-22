package org.example.hibernate_demo_crud.service;

import java.util.List;

import org.example.hibernate_demo_crud.dao.EmployeeDao;
import org.example.hibernate_demo_crud.dao.EmployeeDaoImpl;
import org.example.hibernate_demo_crud.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	{
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(employee);
	}

	@Override
	public List<Employee> displayAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.displayAllEmployee();
	}

	@Override
	public Employee getemployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.getemployeeById(id);
	}

	@Override
	public Employee updateEmployee(Integer id) {
		// TODO Auto-generated method stub
		//return null;
		
		return employeeDao.updateEmployee(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
      
	}

}
