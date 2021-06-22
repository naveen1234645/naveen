package org.example.hibernate_demo_crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.example.hibernate_demo_crud.model.Employee;
import org.example.hibernate_demo_crud.service.EmployeeService;
import org.example.hibernate_demo_crud.service.EmployeeServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
       EmployeeService service=new EmployeeServiceImpl();
    	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String firstName,lastName,email=null;
    	int choice=0;
    	do {
    		try {
        		System.out.println("1. Create Employee.");
        		System.out.println("2. Display All Employees");
        		System.out.println("Find Employee By Id: ");
        		System.out.print("Enter Your Choice: ");
        		choice=Integer.parseInt(bufferedReader.readLine());
        		switch (choice) {
    			case 1:
    				System.out.print("First Name: ");
    				firstName=bufferedReader.readLine();
    				System.out.print("Last Name: ");
    				lastName=bufferedReader.readLine();
    				System.out.print("Email: ");
    				email=bufferedReader.readLine();
    				Employee employee=new Employee(new Random().nextInt(10000), firstName, lastName, email);
    				employee= service.createEmployee(employee);
    				System.out.println("Created: "+employee);
    				break;
    			case 2:
    				List<Employee> list=service.displayAllEmployee();
    				Iterator<Employee> iterator=list.iterator();
    				while(iterator.hasNext())
    				{
    					System.out.println(iterator.next());
    				}
    				break;

    			case 3:
    				System.out.print("id: ");
    				int id=Integer.parseInt(bufferedReader.readLine());
    				employee=service.getemployeeById(id);
    				if(employee==null)
    				{
    					System.out.println("No Such employee found. ");
    				}
    				else
    				{
    					System.out.println("employee found: "+employee);
    				}

    				break;
    			default:
    				System.out.println("invalid choice:");
    				break;
    			}

    		} catch (Exception e) {
    			// TODO: handle exception
    		}

		} while (choice!=0);


    }

}
