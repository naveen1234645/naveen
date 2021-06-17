package comm.example.app;

import comm.example.PrintThread;
import comm.example.PrintRunnable;
import comm.example.ThreadTest;


public class App {

	public static void main(String[] args) {
		

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