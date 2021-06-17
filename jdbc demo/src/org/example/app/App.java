package org.example.app;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;

public class App {

	public static void main(String[] args) throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		List<Employee> employees=dao.getAllEmployees();
		Iterator<Employee> iterator=employees.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());

	}

}