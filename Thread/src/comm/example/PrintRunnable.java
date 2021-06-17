package comm.example;

public class PrintRunnable  implements Runnable{

	private String name;
	private Thread thread;

	public PrintRunnable(String name) {

		this.name = name;
		thread=new Thread(this,name);
		System.out.println(thread.getName());
		thread.start();
	}


	@Override
	public void run() {

		for(int i=0;i<100;i++)
		{
			System.out.println(name+" "+i);
		}
	}

}