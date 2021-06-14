package com.model;

import java.util.Set;

public class EmployeeBO {

	private static void printEmployees(Set<Employee> employees) {
		for (Employee employee : employees) {
			employee.toString();
		}

	}

}
