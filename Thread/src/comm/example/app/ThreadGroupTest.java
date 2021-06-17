package comm.example.app;

import comm.example.PrintThread;

public class ThreadGroupTest {

	public static void main(String[] args) {
		new PrintThread("Jamaica").start();
		new PrintThread("Fiji").start();
		new PrintThread("Bora Bora").start();
		new PrintThread("india").start();
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		Thread[] tarray = new Thread[10];
		int actualSize = group.enumerate(tarray);
		for (int i = 0; i < actualSize; i++) {
			System.out.println("Thread " + tarray[i].getName() + " in thread group " + group.getName());

		}

	}

}
