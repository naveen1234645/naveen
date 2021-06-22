package org.example.demo.services;


import java.sql.SQLException;
import java.util.List;

import org.example.demo.dao.AccountNotValidException;
import org.example.demo.dto.AccountDTO;
import org.example.demo.model.Account;






public interface Service {

    public Account createAccount(Account acc) throws SQLException;

    public List<AccountDTO> displayAllAccount()throws SQLException;

	public void deposit(double amount) throws SQLException;
	public double withdraw(double amount) throws SQLException, AccountNotValidException;
}

