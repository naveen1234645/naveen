package org.example.dao;
import java.sql.SQLException;
import java.util.List;
import org.example.model.Employee;
public interface EmployeeDao {
	
	public Employee createEmployee(Employee employee) throws SQLException;

	public List<Employee> getAllEmployees()throws SQLException;

	public List<Employee> findById(Integer id)throws SQLException;
	public Employee updateEmployee(Integer id)throws SQLException,EmployeeNotFoundException;

	List<Employee> getAllEmployees1() throws SQLException;

	Employee deleteEmployee(Integer id) throws SQLException, EmployeeNotFoundException;

}