package com.loizenai.springboot.mongodb.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
public class Customer {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private Double salary;

	public Customer(String firstname, String lastname, int age, String address, Double salary) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Double getSalary() {
		return this.salary;
	}
	

}