package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemResponseModel {
	private String itemNumber;
	private String itemName;
	private Double itemPrice;
	private Boolean isAvailable;

}