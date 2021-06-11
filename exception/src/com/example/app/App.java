package com.example.app;

import java.util.Scanner;
import java.util.UUID;

import com.example.Todo;

public class App {
	private static Scanner scanner=new Scanner(System.in);

	private Todo[] todos;

	{
		todos=new Todo[3];
	}

	public static void main(String args[])
	{
		App app=new App();
		for(int i=0;i<3;i++)
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
			}
		for(int i=0;i<=5;i++)
		{
		//	try {

				System.out.println(app.todos[i]);

			//} catch (ArrayIndexOutOfBoundsException e) {
				//System.out.println("Array Index Out Of Bound.");

			//}

		}
	}

}
