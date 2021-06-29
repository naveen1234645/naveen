package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.ApplicationConfig;
import com.example.demo.service.EmployeeService;
import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
		/*
		 * try {
		 * 
		 * @SuppressWarnings("resource") ApplicationContext context=new
		 * AnnotationConfigApplicationContext(ApplicationConfig.class);
		 * 
		 * EmployeeService
		 * service=context.getBean("employeeServiceImpl",EmployeeService.class);
		 * EmployeeResponseModel model=service.createEmployee(new
		 * EmployeeRequestModel("John", "Doe", "john@email.com"));
		 * System.out.println(model);
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */
		  

			  @SuppressWarnings("resource") 
			  ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	 BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    	 EmployeeService service=context.getBean("employeeServiceImpl",EmployeeService.class);
         String firstName=null,lastName= null,email=null;
     	 int choice=0;
     	
     	do {
     		try {
         		System.out.println("1. Create Employee.");
         		System.out.println("2. Display All Employees");
         		System.out.println("3.Update Employee By Id: ");
         		System.out.println("4.Delete Employee By Id: ");
         		System.out.println("5.Find Employee By Id: ");
         		System.out.println("0.Exit: ");
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
     				EmployeeResponseModel model=service.createEmployee(new EmployeeRequestModel(firstName, lastName, email));
     	      	   System.out.println(model);
     				break;
     			case 2:
     				List<EmployeeResponseModel> list=service.displayAllEmployee();
     				Iterator<EmployeeResponseModel> iterator=list.iterator();
     				while(iterator.hasNext())
     				{
     					System.out.println(iterator.next());
     				}
     				break;
     				
   
     			case 3:
     				
     				try {
	        			System.out.println("Enter the Employee Id");
	        			String id=bufferedReader.readLine();
	        			EmployeeResponseModel emp =service.findByEmployeeId(id);
	        			if (emp==null)

							throw new EmployeeNotFoundException("Employee with the given id not found.");
						else
						{
							emp=service.updatebyId(id);
							System.out.println("following Employee updated successfully");
							System.out.println(emp);
						}
	        			}
     				catch (EmployeeNotFoundException e) {
 						System.err.println(e.getMessage());
 					}
     				
     				break;
     			case 4:
     				try {
	        			System.out.println("Enter the Employee Id");
	        			String id=bufferedReader.readLine();
	        			EmployeeResponseModel emp=service.findByEmployeeId(id);
	        			if (emp==null)

							throw new EmployeeNotFoundException("Employee with the given id not found.");
						else
						{
							service.deleteEmployee(id);
							
						}
	        			}catch (EmployeeNotFoundException e)
     				{
	 						System.err.println(e.getMessage());
	 					}
     				
     			
     			case 5:
     				
     				 try {
      					
      					System.out.print("id: ");
          				String id=bufferedReader.readLine();
          				 EmployeeResponseModel findmodel=service.findByEmployeeId(id);
          				if (findmodel==null)
          				 
          				{
          					System.out.println("try again...");
          				}
          				else {
          				 System.out.println("found...");
          				System.out.println(findmodel);
          				}
      				}
      				catch (EmployeeNotFoundException e) {
  						System.err.println(e.getMessage());
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