package com.model.example;



import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.model.Employee;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
public class App {
	private void checkSalary(double salary)
	{
		if(salary<5000)
		{
			throw new InvalidSalaryException("Invalid Price");
		}
	}

	private static Scanner sc=new Scanner(System.in);
	public static void main(String args[])
	{

		int choice=0;
		Set<Employee> set=new TreeSet<Employee>();
		App app=new App();


		do {
			try {
			System.out.println("Select your choice...");
			System.out.println("1. Enter the details");
			System.out.println("2. Show Employee Information");
			System.out.println("0. Exit");
			choice=sc.nextInt();


		switch(choice)
		{

		case 1:
		System.out.println("Enter the first name");
		String fname=sc.next();
		System.out.println("Enter the last name");
		String lname=sc.next();
		System.out.println("Enter the emailId");
		String email=sc.next();
		System.out.println("Enter the salary");
		double salary=sc.nextDouble();
		app.checkSalary(salary);
		set.add(new Employee(UUID.randomUUID().toString(),fname,lname,email,salary));

		 break;

		case 2:

			Iterator<Employee> i=set.iterator();
			while(i.hasNext())
			{
//				Employee emp=i.next();
				System.out.println(i.next());
			}
		 break;
		case 0:
			System.out.println("Exiting...Bye");
			System.exit(0);

		default:

			System.out.println("Invalid choice");
			break;
		}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Invalid Input");
		}
		}while(choice!=0);


}
}