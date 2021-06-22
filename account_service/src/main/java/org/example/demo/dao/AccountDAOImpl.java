package org.example.demo.dao;

public class AccountDAOImpl {
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.demo.dto.AccountDTO;
import org.example.demo.factory.MyConnectionFactory;
import org.example.demo.model.Account;

public class AccountDAOImpl implements AccountDAO {

	private Connection connection;
	private List<AccountDTO> accounts;
	private Account acc;
	private MyConnectionFactory myConnectionFactory;


	{
		try {
			myConnectionFactory = MyConnectionFactory.createFactory();
			connection = myConnectionFactory.getMyConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Account createAccount(Account account) throws SQLException {

		PreparedStatement preparedStatement = connection.prepareStatement("insert into account values(?,?,?,?,?,?,?)");
		preparedStatement.setString(1, account.getAccountId());
		preparedStatement.setString(2, account.getAccountType().getMessage());
		preparedStatement.setString(3, account.getAccountHolderName());
		preparedStatement.setString(4, account.getAddress().getAddressLine1());
		preparedStatement.setString(5, account.getAddress().getAddressLine2());
		preparedStatement.setString(6, account.getAddress().getCity().getCity());
		preparedStatement.setDouble(7, account.getBalance());
		preparedStatement.executeUpdate();
		return account;
	}

	@Override
	public List<AccountDTO> displayAllAccount() throws SQLException {

		accounts = new ArrayList<AccountDTO>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from account");
		while (resultSet.next()) {

			accounts.add(new AccountDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDouble(7)));
		}

		return accounts;
	}

	@Override
	public void deposit(double amount) throws SQLException {
		acc.setBalance(amount+acc.getBalance());
		System.out.println("Rs. "+amount+" deposited successfully");
		System.out.println("The new balance is Rs."+acc.getBalance());
		PreparedStatement preparedStatement = connection.prepareStatement("insert into account(balance) values(?)");
		preparedStatement.setDouble(1, acc.getBalance());
		preparedStatement.executeUpdate();



	}

	@Override
	public double withdraw(double amount) throws SQLException, AccountNotValidException {
		// TODO Auto-generated method stub

		if(acc.getBalance()>500)
		{
			double newAmount=acc.getBalance()-amount;
			if(newAmount>500)
			{
				acc.setBalance(newAmount);
				PreparedStatement preparedStatement = connection.prepareStatement("insert into account(balance) values(?)");
				preparedStatement.setDouble(1, acc.getBalance());
				preparedStatement.executeUpdate();
			}
			else
			{
				throw new AccountNotValidException("Enter valid amount to withdraw");
			}
		}
		else
		{
			throw new AccountNotValidException("Enter valid amount to withdraw");
		}

		return acc.getBalance();

	}


	}

}