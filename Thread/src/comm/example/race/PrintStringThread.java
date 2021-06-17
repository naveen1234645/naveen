package comm.example.race;
public class PrintStringThread implements Runnable {
	private Thread thread;
	private String str1;
	private String str2;
	private TwoString twoString;

	
	public PrintStringThread(String str1, String str2,TwoString twoString) {
		this.str1 = str1;
		this.str2 = str2;
		this.twoString=twoString;
		thread=new Thread(this);
		thread.start();

	}
	@Override
	public void run() {

		TwoString.print(str1, str2);
		synchronized (twoString) {
			twoString.print(str1, str2);

		}

	}

}