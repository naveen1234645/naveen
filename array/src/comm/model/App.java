
package comm.example;

import java.util.Scanner;

public class App {

	private char[] s;
	

	private static Scanner scanner=new Scanner(System.in); 

	public static void main(String[] args) {
		//orphan object
		char[] str=new App().CreateArray();
		//Enhanced for loop
		for(char s:str)
		{
			System.out.println(s);
		}
		System.out.println("======================");
		//for loop
		for(int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		


		int choice=0;
		MyStack myStack=new MyStack();
		System.out.print("Enter the length of the Stack:  ");
		int length=scanner.nextInt();
		myStack.createStack(length);
		do {
			System.out.println("1. Push.");
			System.out.println("2. Pop.");
			System.out.println("0. Exit");
			System.out.print("enter your choice");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("provide an integer value to push.");
				int value=scanner.nextInt();
				myStack.push(value);
				break;
			case 2:
				myStack.pop();
				break;
			case 0:
				System.out.println("exiting from the system. Bye .........!");
				System.exit(0);

			default:
				System.out.println("invalid choice");
				break;
			}

		} while (choice !=0);








	}

}