package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rentId;
	private String movieName;
	private double rentAmount;

}