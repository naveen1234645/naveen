package org.example.spring_ioc_java_based;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;



import org.example.spring_ioc_java_based.config.MyConfig;
import org.example.spring_ioc_java_based.dao.AccountDao;
import org.example.spring_ioc_java_based.dao.AccountDaoImpl;
import org.example.spring_ioc_java_based.pojo.Account;
import org.example.spring_ioc_java_based.service.AccountService;
import org.example.spring_ioc_java_based.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		try {

			@SuppressWarnings("resource")
			ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

			
			 AccountService service=context.getBean("accountServiceImpl",AccountServiceImpl.class);
				/*
				 * account.setId(1); String str[]=UUID.randomUUID().toString().split("-");
				 * account.setAccountid(str[4]); account.setAccountHolderName("John Doe");
				 * account.setAccountBalance(10000); System.out.println(account);
				 */ 
			int choice=-1;
			String accountHolderName=null;
			double balance=0;
			do {
				System.out.println("1. Create Account: ");
				System.out.println("2: Display All Account: ");
			    System.out.println("3. Account Deleting:");
				System.out.println("0. Exit");
				System.out.print("Your Choice: ");
				choice=scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Account Holder Name: ");
					accountHolderName=scanner.next();
					System.out.println("Balance: ");
					balance=scanner.nextDouble();
					String str[]=UUID.randomUUID().toString().split("-");
					Account account=new Account();
					account.setId(new Random().nextInt(1000));
					account.setAccountid(str[4]);
					account.setAccountHolderName(accountHolderName);
					account.setAccountBalance(balance);
					Account tempAccount=service.createAccount(account);
					System.out.println("Account Created Sucessfully: "+tempAccount);
					break;
				case 2:
					List<Account> accounts=service.displayAllAvailableAccount();
					Iterator<Account> i=accounts.iterator();
					System.out.println("================Displaying Account Details==================\n");
					while(i.hasNext())
					{
						System.out.println(i.next());
					}
					break;
				case 3:
					System.out.println("Enter Account id to delete ");
					String id = scanner.next();
					service.deleteAccount(id);
					System.out.println("Removed");
				    break;
				default:
					break;
				
				}
				
			} while (choice!=0);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}