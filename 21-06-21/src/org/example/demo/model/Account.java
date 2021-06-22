package org.example.demo.model;

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
public class Account {

	private String accountId;
	private AccountType accountType;
	private String accountHolderName;
	private Address address;
	private double balance;


}