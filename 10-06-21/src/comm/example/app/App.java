package comm.example.app;

import java.util.Scanner;

import comm.example.Employee;
import comm.example.Engineer;
import comm.example.Manager;

import static java.lang.System.out;
import static java.lang.System.in;
import static comm.example.Employee.max;
import static java.lang.Math.PI;
import static comm.example.EmployeeType.HOORLY_PAID;
import static comm.example.EmployeeType.SALARIED;
public class App {

	

	private static Scanner scanner=new Scanner(in);
	private Employee[] employees;

	{
		employees=new Employee[5];
	}
	public static void main(String args[])
	{
		int a=max;
		System.out.println(a);
		System.out.println(PI);
		App app=new App();
		
		app.employees[0]=new Employee(10, "John", "Doe", "john@email.com",SALARIED);
		app.employees[1]=new Manager(20, "Marry", "Public", "marry@email.com", HOORLY_PAID,"Sales");
		app.employees[2]=new Engineer(30, "Sachin", "Tendulkar", "sachin@email.com", SALARIED, "Mechanical");



		//standard for loop
		for(int i=0;i<app.employees.length;i++)
		{
			System.out.println(app.employees[i]);
			out.println(app.employees[i]);
		}

	}

} 