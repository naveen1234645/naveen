package com.model.app;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.model.AgeComparator;
import com.model.Employee;
import com.model.SortbyAge;

public class App {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int emp_id = 1;
		AgeComparator ageComparator = new AgeComparator();
		Set<Employee> set = new TreeSet<Employee>(ageComparator);

		boolean choice;
		do {
			Employee emp = new Employee();
			emp.setId(emp_id);
			System.out.println("Enter Employee name");
			emp.setName(sc.next());
			System.out.println("Enter department");
			emp.setDepartment(sc.next());
			System.out.println("Enter DOJ(dd-mm-yyyy)");
			String Sdate = sc.next();
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(Sdate);
			emp.setDateOfJoining(date1);
			System.out.println("Enter salary");
			emp.setSalary(sc.nextInt());
			System.out.println("Enter age");
			emp.setAge(sc.nextInt());
			set.add(emp);
			System.out.println("Add employee details(true/false)");
			choice = sc.nextBoolean();
			emp_id++;
		} while (choice);
//		for (Employee employee : set) {
//			System.out.println(employee);
//		}

		int choice1;

		do {
			System.out.println("1.Sort employees by age and by date of joining\n2.Sort employees by salary");
			choice1 = sc.nextInt();

			switch (choice1) {

			case 2:
				System.out.println("Sort by salary");
				SortbyAge sortByAge = new SortbyAge();
				Set<Employee> set1 = new TreeSet<Employee>(sortByAge);
				set1.addAll(set);

				for (Employee employee : set1) {
					System.out.println(employee);
				}

				break;
			case 1:
				System.out.println("Sort by age ");
				for (Employee employee : set) {
					System.out.println(employee);
				}

				break;
			}
		} while (choice1 != 0);

	}

}
