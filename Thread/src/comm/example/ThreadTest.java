package comm.example;

public class ThreadTest implements Runnable{


	public void display()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println(i);
		}
	}

	@Override
	public void run() {
		display();

	}

}