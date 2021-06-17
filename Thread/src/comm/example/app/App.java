package comm.example.app;

import comm.example.PrintThread;
import comm.example.PrintRunnable;
import comm.example.ThreadTest;


public class App {

	public static void main(String[] args) {
		/*
		 * ThreadTest test=new ThreadTest();
		 * 
		 * Thread t=new Thread(test); System.out.println(t.getName()); t.start(); Thread
		 * t1=new Thread(test); System.out.println(t1.getName()); t1.start(); Thread
		 * t2=new Thread(test); t2.start();
		 */
		

		//new PrintThread("A");
		//thread1.start();
		//new PrintThread("B");
		//thread2.start();
		
		
		PrintRunnable printRunnable=new PrintRunnable("A"); 
		Thread t1=new Thread(printRunnable); t1.start();
		PrintRunnable printRunnable1=new PrintRunnable("B");
		Thread t2=new Thread(printRunnable1); t2.start();
	}

}