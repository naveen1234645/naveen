package comm.example.app;

import comm.example.PrintThread;
import comm.example.ThreadTest;

public class App {

	public static void main(String[] args) {
		ThreadTest test=new ThreadTest();

		Thread t=new Thread(test);
		System.out.println(t.getName());
		t.start();
		Thread t1=new Thread(test);
		System.out.println(t1.getName());
		t1.start();
		Thread t2=new Thread(test);
		t2.start();
		

		PrintThread thread1=new PrintThread("A");
		thread1.start();
		PrintThread thread2=new PrintThread("B");
		thread2.start();
	}

}