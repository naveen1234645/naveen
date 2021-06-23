package org.example.demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "university")

public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer universityId;
	@Column(name = "university_name")
	private String name;
	@Column(name = "country")
	private String country;
	
	
	
	
	@OneToMany(cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	private List<Student> st;
	
	public void add(Student tempStudent)
	
	{
		if(st==null) {
			st=new ArrayList<Student>();
			
		}
		st.add(tempStudent);
		tempStudent.setUniversity(this);
		
		
	}
	
	
	
	
	

}