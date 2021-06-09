package comm.model;

import java.util.Arrays;
public class MyStack {
	private int[] info;
	private int index;
	private int size;
	
	{
		index=-1;
	}
	
	public void createStack(int size)
	{
		this.size=size;
		info=new int[this.size];
		System.out.println("stack creaated sucessfully..!");
	}
	
	public void push(int item)
	{
		if(index>=size)
		{
			System.out.println("stack overflow");
			
		}
		else
		{
			info[++index]=item;
			System.out.println("pushed sucessfully...");
		}
		
	}
	
	public void pop()
	{
		if(index==-1)
		{
			System.out.println("stack underflow..");
		}
		else
		{
			System.out.println("popped-->> "+info[index--]);
		}
	}
	public void searchStack(int item)
	{
		int position=Arrays.binarySearch(info, item);
		if(position>=0)
			System.out.println("item found at "+position+" position");
		else
			System.out.println("item not found.");
	}

	public int[] displayStack()
	{
		return info;
	}
	public int[] sortStack()
	{
		 Arrays.sort(info);
		 return info;
	}

}
