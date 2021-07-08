package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name ="First_Name")
	private String First_Name;
	@Column(name = "Last_Name")
	private String Last_Name;
	@Column(name ="Email")
	private String Email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	
	//@JsonManagedReference
	
	private InstructorDetail instructorDetail;
	@OneToMany(mappedBy="instructor",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;

}