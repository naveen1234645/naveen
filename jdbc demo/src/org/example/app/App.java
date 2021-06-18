package org.example.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
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
import org.example.db.Database;
import org.example.db.DbtoFile;
public class App {
	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		Database db=new Database();
		DbtoFile dtf=new DbtoFile();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		EmployeeService service = new EmployeeServiceImpl();
		int choice = 0;
		String firstName, lastName, email = null;
		do {

			System.out.println("1. Create a new employee");
			System.out.println("2. display all available employees");
			System.out.println("3. find employee by id");
			System.out.println("4. delete employee  id");
			System.out.println("5. create employee file");
			System.out.println("6.Enter Data of Employee to File from Database");
			System.out.println("0. exit");
			System.out.print("enter your choice: ");
			choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
			case 1:
				System.out.print("enter first name: ");
				firstName = bufferedReader.readLine();
				System.out.print("enter last name");
				System.out.print("enter last name: ");
				lastName = bufferedReader.readLine();
				System.out.print("enter email: ");
				email = bufferedReader.readLine();
				Employee employee = service
						.createEmployee(new Employee(new Random().nextInt(100), firstName, lastName, email));
				System.out.println(employee);
				break;
			case 2:
				List<Employee> employees = service.getAllEmployees();
				Iterator<Employee> iterator = employees.iterator();
				while (iterator.hasNext())
					System.out.println(iterator.next());
				break;
			case 3:
				System.out.print("enter id: ");
				Integer id = Integer.parseInt(bufferedReader.readLine());
				List<Employee> list=service.findById(id);
				if(list.isEmpty())
				{
					System.out.println("NO such record found with id: "+id);
				}
				else
				{
					for(Employee e:list)
					{
						System.out.println(e);
					}
				}
				break;
				
			case 4:
				System.out.print("enter id: ");
				Integer id1 = Integer.parseInt(bufferedReader.readLine());
				List<Employee> list1=service.findById(id1);
				if(list1.isEmpty())
				{
					System.out.println("NO such record found with id: "+id1);
				}
				else
				{
					for(Employee e:list1)
					{
						System.out.println(e);
					}
				}



				break;
			case 5:
				try {
				System.out.println("Enter the File name ");
				String file1=bufferedReader.readLine();
				List<Employee> list11=db.createFromFile(file1);
				Iterator<Employee> i=list11.iterator();
				while(i.hasNext())
				{
					Employee emp=i.next();
					emp=service.createEmployee(new Employee(new Random().nextInt(100),emp.getFirstName(),emp.getLastName(),emp.getEmail()));
				}

				System.out.println("Employee Details added from file successfully!");
				}catch(FileNotFoundException e)
				{
					System.err.println("File not available. Please try again");
				}



				break;
			case 6:
				System.out.println("create a new file name or Enter the existing file name for saving details");
				String filename=bufferedReader.readLine();
				dtf.toFile(filename);
				
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