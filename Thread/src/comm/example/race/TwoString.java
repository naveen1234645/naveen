package comm.example.race;

public class TwoString {

	public synchronized static void print(String str1,String str2)
	//public void print(String str1,String str2)
	{

		System.out.print(str1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(str2);
	}
}