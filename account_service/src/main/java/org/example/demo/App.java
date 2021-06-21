package org.example.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.example.demo.dao.AccountDAO;
import org.example.demo.dao.AccountDAOImpl;
import org.example.demo.dto.AccountDTO;
import org.example.demo.model.Account;
import org.example.demo.model.AccountType;
import org.example.demo.model.Address;
import org.example.demo.model.City;

public class App 
{


    public static void main( String[] args ) throws SQLException
    {
    	AccountDAO accountDAO=new AccountDAOImpl();
		/*
		 * Account account=accountDAO.createAccount (new
		 * Account(UUID.randomUUID().toString(), AccountType.SAVINGS,"Marry" , new
		 * Address("2A", "INDIA", City.MUMBAI), 1000)); System.out.println(account);
		 */
    	List<AccountDTO> list=accountDAO.displayAllAccount();
    	for(AccountDTO dto:list)
    	{
    		System.out.println(dto);
    	}

    }
}
