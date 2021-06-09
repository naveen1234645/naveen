package comm.example;

public class Account {

	private String accountNumber;
	private String accountHolderName;
	private double balance;


	public static void main(String args[])
	{
		int a=100;
		//boxing
		Integer z=new Integer(a);
		//autoboxing
		Integer b=a;
		System.out.println(a);
		System.out.println(b);
		//unboxing
		int x=b.intValue();
		//auto unboxing
		int y=b;
		String str="100";
		int result=Integer.parseInt(str);
		System.out.println(result);
	}

}
