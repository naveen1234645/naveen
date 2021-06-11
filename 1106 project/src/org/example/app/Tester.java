package org.example.app;


import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.example.Beer;

public class Tester {

	private Map<Integer, Beer> map=null;

	{
		map=new HashMap<Integer,Beer>();
	}

	private static Scanner scanner=new Scanner(System.in);
	public static void main(String args[])

	{
		int key=1;
		int choice=0;
		Tester tester=new Tester();

		do
		{
			try {
				System.out.println("1. Add A New Beer.");
				System.out.println("2. Display All Available Beer.");
				System.out.println("0. Quit");
				System.out.print("Enter Your choice: ");
				choice=scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Beer Name: ");
					String name=scanner.next();
					System.out.print("Beer Price: ");
					double price=scanner.nextDouble();
					tester.map.put(key++, new Beer(UUID.randomUUID().toString(), name, price));
					System.out.println("Beer Added Sucessfully...");
					break;
				case 2:
					Collection<Beer> collection=tester.map.values();
					Iterator<Beer> i=collection.iterator();
					while(i.hasNext())
					{
						Beer b=i.next();
						System.out.println(b);
					}

					break;
				case 0:
					System.out.println(tester.map);
					System.out.println("Exit from System. Bye..");

					System.exit(0);
					break;

				default:
					System.out.println("Invalid Choice Try Again.");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("input mispatched.");

			}

		}while(choice!=0);



	}

}