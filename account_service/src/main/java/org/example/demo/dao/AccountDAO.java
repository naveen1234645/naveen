

package org.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.demo.dto.AccountDTO;
import org.example.demo.model.Account;

public interface AccountDAO {

	public Account createAccount(Account account)throws SQLException;
	public List<AccountDTO> displayAllAccount()throws SQLException;
	public void deposite(double amount) throws SQLException;
	public double withdrawl(double amount) throws SQLException;


}