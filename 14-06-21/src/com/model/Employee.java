package com.model;



public class Employee implements Comparable {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(String employeeId, String firstName, String lastName, String email, double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if ((this.salary > ((Employee) o).salary))
			return -1;
		else if ((this.salary < ((Employee) o).salary))
			return 1;
		return 0;
	}

}