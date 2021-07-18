package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student{
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Length(min = 3, max = 255, message = "first name must be atleast 3 char long")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Length(min = 3, max = 255, message = "last name must be atleast 3 char long")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;

}