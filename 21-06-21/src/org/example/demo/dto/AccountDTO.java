package org.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AccountDTO {
	private String accountId;
	private String accountType;
	private String accountHolderName;
	private String  addressLine1;
	private String addressLine2;
	private String city;
	private double balance;

}