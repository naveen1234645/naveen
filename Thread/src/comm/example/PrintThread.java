package comm.example;
public class PrintThread extends Thread{
	
	public PrintThread(String name)
	{
		super(name);
		start();

	}

	@Override
	public void run() {
		String name=getName();

		for(int i=0;i<100;i++)
		{
			System.out.println(name+"-->"+i);
		//for(int i=0;i<100;i++)
		//{
			System.out.println(name);

		}
		//}
	}

}