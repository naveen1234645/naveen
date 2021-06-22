package org.example.demo.services;

import java.sql.SQLException;
import java.util.List;

import org.example.demo.dao.AccountDAO;
import org.example.demo.dao.AccountNotValidException;
import org.example.demo.dto.AccountDTO;
import org.example.demo.model.Account;

public class ServiceImpl implements Service{
     private AccountDAO accountDao;
	@Override
	public Account createAccount(Account acc) throws SQLException {
		// TODO Auto-generated method stub

		return accountDao.createAccount(acc);



	}

	@Override
	public List<AccountDTO> displayAllAccount()throws SQLException{
		// TODO Auto-generated method stub
		return accountDao.displayAllAccount();
	}

	@Override
	public void deposit(double amount) throws SQLException {
		// TODO Auto-generated method stub
		accountDao.deposit(amount);
	}

	@Override
	public double withdraw(double amount) throws SQLException, AccountNotValidException {
		// TODO Auto-generated method stub
		double balance = 0;
		try {
			 balance=accountDao.withdraw(amount);

		}catch(AccountNotValidException e)
		{
			System.err.println("Invalid Amount!");
		}
		return balance;
	}

	}

