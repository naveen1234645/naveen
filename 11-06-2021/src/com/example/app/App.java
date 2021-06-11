package com.example.app;
import java.util.Scanner;
import java.util.UUID;

import com.example.Employee;
import com.example.Manager;
import com.example.Todo;

public class App {
	private static Scanner scanner=new Scanner(System.in);

	private Todo[] todos;

	{
		todos=new Todo[2];
	private static Scanner scanner = new Scanner(System.in);

	/*
	 * private Todo[] todos;
	 * 
	 * { todos=new Todo[2]; }
	 */

	public static void main(String args[]) {
		App app = new App();
		/*
		 * for(int i=0;i<2;i++) { try { System.out.print("ToDo Desc: "); String
		 * tempDesc=scanner.next(); System.out.print("isCompleted? "); boolean
		 * tempIsCompleted=scanner.nextBoolean(); app.todos[i]=new
		 * Todo(UUID.randomUUID().toString(), tempDesc, tempIsCompleted);
		 * 
		 * 
		 * } catch (ArrayIndexOutOfBoundsException e) {
		 * System.err.println("array index out of bound exception."); } } for(int
		 * i=0;i<=5;i++) { try {
		 * 
		 * System.out.println(app.todos[i]);
		 * 
		 * } catch (ArrayIndexOutOfBoundsException e) {
		 * //System.out.println("Array Index Out Of Bound.");
		 * 
		 * }
		 * 
		 * }
		 */
		Employee employee = null;
		Manager manager = new Manager();
		app.check(manager);

		app.check(employee);

	}

	public static void main(String args[])
	{
		App app=new App();
		for(int i=0;i<2;i++)
		{
			try {
				System.out.print("ToDo Desc: ");
				String tempDesc=scanner.next();
				System.out.print("isCompleted? ");
				boolean tempIsCompleted=scanner.nextBoolean();
				app.todos[i]=new Todo(UUID.randomUUID().toString(), tempDesc, tempIsCompleted);


			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("array index out of bound exception.");
			}

	private void check(Employee o) {
		try {
		//	int a = 100 / 0;
			if (o instanceof Manager) {
				Manager manager = (Manager) o;
				System.out.println("Manager" + manager.toString());
			} else {
				System.out.println(o.toString());
			}
		for(int i=0;i<=5;i++)
		{
		//	try {

				System.out.println(app.todos[i]);

			//} catch (ArrayIndexOutOfBoundsException e) {
				//System.out.println("Array Index Out Of Bound.");

			//}


		}

		/*
		 * catch (NullPointerException e) {
		 * System.err.println("null pointer exception"); e.printStackTrace(); }
		 */catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("array index out of bound exception");
		}
		catch (ArithmeticException e) {
			System.err.println("arithemetic");
			e.printStackTrace();
		}

		/*
		 * catch (Exception e) { System.err.println(e.toString()); }
		 */
	}

}