package org.example.spring_ioc_java_based.dao;


import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.example.spring_ioc_java_based.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {

	private List<Account> list;

	@Autowired
	public AccountDaoImpl(List<Account> list) {
		this.list = list;
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		list.add(account);
		return account;
	}

	@Override
	public List<Account> displayAllAvailableAccount() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public void deleteAccount(String id) {
		// TODO Auto-generated method stub
		 list = new ArrayList<Account>();
		 Iterator<Account> i = list.iterator();
		 Account account = null;
		 while(i.hasNext())
		 {
			account  = i.next();
			if(account.getAccountid().equals(id)){
				System.out.println("found: " +account);
				list.remove(account);
				System.out.println("removed.");
					break;
				}
				else
				{
					System.out.println("Invalid id");
					break;
				}
			}

}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

}