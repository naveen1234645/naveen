package org.example.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;

public class App {

	/*public static void main(String[] args) throws SQLException {
	EmployeeService service=new EmployeeServiceImpl();
		List<Employee> employees=service.getAllEmployees();
		Iterator<Employee> iterator=employees.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());*/
	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		EmployeeService service = new EmployeeServiceImpl();
		int choice = 0;
		String firstName, lastName, email = null;
		do {

			System.out.println("1. Create a new employee");
			System.out.println("2. display all available employees");
			
			System.out.println("0. exit");
			System.out.print("enter your choice: ");
			choice = Integer.parseInt(bufferedReader.readLine());

			switch (choice) {
			case 1:
				System.out.print("enter first name: ");
				firstName = bufferedReader.readLine();
				System.out.print("enter last name");
				lastName = bufferedReader.readLine();
				System.out.print("enter email: ");
				email = bufferedReader.readLine();
				Employee employee = service.createEmployee(new Employee(new Random().nextInt(100), firstName, lastName, email));
				System.out.println(employee);
				break;
			case 2:
				List<Employee> employees = service.getAllEmployees();
				Iterator<Employee> iterator = employees.iterator();
				while (iterator.hasNext())
					System.out.println(iterator.next());
				break;
			
					
				
			case 0:
				System.out.println("Bye!");
				System.exit(0);
				break;
			default:
				System.out.println("invalid choice");
				break;
			}

		} while (choice != 0);



	}

}