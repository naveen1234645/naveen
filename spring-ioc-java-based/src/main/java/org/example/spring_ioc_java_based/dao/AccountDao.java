package org.example.spring_ioc_java_based.dao;


import java.util.List;

import org.example.spring_ioc_java_based.pojo.Account;

public interface AccountDao {
	
	public Account createAccount(Account account);
	
	public List<Account> displayAllAvailableAccount();
	public void deleteAccount(String id);

}