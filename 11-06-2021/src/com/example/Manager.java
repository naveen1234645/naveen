package com.example;


public class Manager extends Employee {
	private String dept;

	public Manager() {
		super();
	}

	public Manager(int id, String name, String dept) {
		super(id, name);
		this.dept=dept;

	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Manager [dept=" + dept + ", toString()=" + super.toString() + "]";
	}



}