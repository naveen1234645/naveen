package comm.model;
import java.util.Scanner;
public class App { 
	
	private static Scanner scanner=new Scanner(System.in); 
 
	public static void main(String[] args) {
		int choice=0;
		MyStack myStack = new MyStack();
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

		
		Point point[]=new Point[10];
		point[0]=new Point(10, 20);
		//multidimentional array
		int arr[][]=new int[3][10];






		}

	}