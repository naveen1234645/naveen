package com.example.exception;

public class Manager2 extends Employee2{
	private String departmentName;

	public Manager2() {
		super();

		}
	public Manager2(int id, String name,String departmentName) {
		super(id, name);
		this.departmentName=departmentName;

	}
	@Override
	public String toString() {
		return "Manager2 [departmentName=" + departmentName + ", toString()=" + super.toString() + "]";
	}




}