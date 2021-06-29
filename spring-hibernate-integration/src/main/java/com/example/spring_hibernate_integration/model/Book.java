package com.example.spring_hibernate_integration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	@Id
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_price")
	private Double bookPrice;

}