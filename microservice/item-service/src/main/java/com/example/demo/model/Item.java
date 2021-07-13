package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_table")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "item_number", unique = true)
	private String itemNumber;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_price")
	private Double itemPrice;
	@JsonProperty
	@Column(name = "available")
	private Boolean isAvailable;

	public Item(String itemNumber, String itemName, Double itemPrice, Boolean isAvailable) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.isAvailable = isAvailable;
	}
}