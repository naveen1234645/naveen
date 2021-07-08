package com.example.demo.entity;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name ="youtube_channel")
	private String youtubeChannel;
	@Column(name ="hobby")
	private String hobby;
	//@OneToOne(mappedBy ="instructorDetail", cascade = CascadeType.ALL)
	//@JsonBackReference
	@OneToOne(mappedBy="instructorDetail", 
	cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
				CascadeType.REFRESH})
	private Instructor instructor;

}