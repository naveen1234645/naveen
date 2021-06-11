package com.example.test;
import java.util.InputMismatchException;
import com.example.exception.Employee2;
import com.example.exception.Manager2;
import java.util.Scanner;
import java.util.UUID;
import com.example.exception.ExceptionT;
public class Test {
	private static Scanner sc=new Scanner(System.in);

	private ExceptionT[] exception;
	/*private ExceptionT[] exception;
	
	{
		exception=new ExceptionT[5];
	}
	}*/

	public static void main(String args[])
	{
		Test t=new Test();
		for(int i=0;i<5;i++)
		/*for(int i=0;i<5;i++)
		{
			try {
				String tempId =UUID.randomUUID().toString();
				System.out.print("ToDo Desc: ");
				String tempDesc=sc.next();
				System.out.print("isCompleted? ");
				boolean tempIsCompleted=sc.nextBoolean();
				t.exception[i]=new ExceptionT(UUID.randomUUID().toString(), tempDesc, tempIsCompleted);
			}catch(ArrayIndexOutOfBoundsException e) 
			{
				System.err.println("Array index out of bound exception.");
			}catch(InputMismatchException e) 
			{
				System.err.println("Enter input value:");
				i--;
				continue;
			}
			
		}
		for(int i1=0;i1<=5;i1++) {
			System.out.println(t.exception[i1]);
			
		}
	
    }
    }*/
		Employee2 emp = null;
		Manager2 man = new Manager2();
		t.check(man);

		t.check(emp);
	}

	private void check(Employee2 emp) {
		try {
			if (emp instanceof Manager2) {
				Manager2 manager = (Manager2) emp;
				System.out.println("Manager" + manager.toString());
			} else {
				System.out.println(emp.toString());
			}


		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("array index out of bound exception");
		}
		catch (ArithmeticException e) {
			System.err.println("arithemetic");
			e.printStackTrace();
		}

	}
}