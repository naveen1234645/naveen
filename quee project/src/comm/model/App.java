package comm.model;
import java.util.Scanner;

public class App {
	private static Scanner scanner=new Scanner(System.in); 

	public static void main(String[] args) {
		int choice=0;
		Queue queue1=new Queue();
		System.out.print("Enter the length of the Queue:  ");
		int length=scanner.nextInt();
		queue1.createQueue(length);
		do {
			System.out.println("1. Push.");
			System.out.println("2. Pop.");
			System.out.println("0. Exit");
			System.out.print("enter your choice");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print(" Integer value to push.");
				int value=scanner.nextInt();
				queue1.push(value);
				break;
			case 2:
				queue1.pop();
				break;
			case 0:
				System.out.println("Exiting System. Bye .........!");
				System.exit(0);

			default:
				System.out.println("Invalid choice");
				break;
			}

		} while (choice !=0);

		}


}


