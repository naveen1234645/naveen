package org.example.demo;

/**
 * Hello world!
 *
 */
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.example.demo.dao.AccountDAO;
import org.example.demo.dao.AccountDAOImpl;
import org.example.demo.dto.AccountNotValidException;
import org.example.demo.dto.AccountDTO;
import org.example.demo.model.Account;
import org.example.demo.model.AccountType;
import org.example.demo.model.Address;
import org.example.demo.model.City;
import org.example.demo.services.Service;
import org.example.demo.services.ServiceImpl;


public class App 
{
   // public static void main( String[] args )

	private static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args ) throws SQLException, AccountNotValidException
    {
        System.out.println( "Hello World!" );
    	AccountDAO accountDAO=(AccountDAO) new AccountDAOImpl();
    	Service service = new ServiceImpl();
    	Address address = null;
    	int choice = 0;
		/*
		 * Account account=accountDAO.createAccount (new
		 * Account(UUID.randomUUID().toString(), AccountType.SAVINGS,"Marry" , new
		 * Address("2A", "INDIA", City.MUMBAI), 1000)); System.out.println(account);
		 */
    /*	List<AccountDTO> list=accountDAO.displayAllAccount();
    	for(AccountDTO dto:list)
    	{
    		System.out.println(dto);
    	}*/
    	do {
        System.out.println("1.To Create account");

		System.out.println("2.To Display Account");

		System.out.println("3.To Deposit Amount");

		System.out.println("4.To Withdraw Amount");

		System.out.println("0.To Exit");
		choice=scanner.nextInt();

		switch(choice)
    	{
    	case 1:
    		int select;
    		String accountType=null,city=null;
    		System.out.println("Enter the Account type");
			System.out.println("1.Saving Account");
			System.out.println("2.Credit_card");
			System.out.println("3.Loan");
			System.out.println("4.Current");
			select = scanner.nextInt();
    	    if(select==1)
    	    {
    	    	 accountType=AccountType.SAVINGS.toString();
    	    }
    	    else if(select==2)
    	    {
    	    	accountType=AccountType.CREDIT_CARD.toString();
    	    }
    	    else if(select==3)
    	    {
    	    	accountType=AccountType.LOAN.toString();
    	    }
    	    else if(select == 4)
    	    {
    	    	accountType=AccountType.CURRENT.toString();
    	    }

    	    else {
    	    	System.out.println("Enter valid Account type.");
    	    }

    	    System.out.println("Enter the account holder name");
			String name=scanner.next();
			System.out.println("Enter the address");
			System.out.println("Enter the address line 1");
			String addline1=scanner.next();

			System.out.println("Enter the address line 2");
			String addline2=scanner.next();

			System.out.println("Enter the city");
			System.out.println("1.Chennai");
			System.out.println("2.Kolkata");
			System.out.println("3.Mumbai");
			System.out.println("4.Hydrabad");
			int city_choice = scanner.nextInt();
			if(city_choice==1)
			{
				city = City.CHENNAI.toString();
			}
			else if(city_choice==2)
			{
				city = City.KOLKATA.toString();
			}
			else if(city_choice==3)
			{
				city = City.MUMBAI.toString();
			}
			else if(city_choice==4)
			{
				city= City.HYDRABAD.toString();
			}
			else
			{
				System.out.println("Enter valid choice");
			}

			Account account = accountDAO.createAccount(new Account(UUID.randomUUID().toString(),AccountType.valueOf(accountType),name,new Address(addline1,addline2,City.valueOf(city)),5000));
			System.out.println(account);
			break;

    	case 2:
			List<AccountDTO> list=accountDAO.displayAllAccount();
			Iterator<AccountDTO> iterator = list.iterator();
			while (iterator.hasNext())
				System.out.println(iterator.next());
			break;	

    	case 3:
    		System.out.println("Enter the amount you want to deposit");
			double amount = scanner.nextDouble();
			accountDAO.deposit(amount);
			break;

    	case 4:
    		System.out.println("Enter the amount you want to withdraw");
			amount = scanner.nextDouble();
			double balance = (double)accountDAO.withdraw(amount);
			System.out.println("Total amount available:");
			break;

    	case 0:
    		System.out.println("Bye!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;

    	}
   }while(choice!=0);









    }
}