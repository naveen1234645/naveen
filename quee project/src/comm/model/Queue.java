package comm.model;


import java.util.Arrays;

public class Queue {
	private int[] info;
	private int index;
	private int size;
	private int A;
	private int B;
	{
		A= -1;
		B= -1;

	}
	public void createQueue(int size) {
		this.size =size;
		info =new int[this.size];
		System.out.println("Created Queue....");

	}
	public void push(int item) {
		if(A>B) {
			System.out.println("Queue Overflow");
		}
		else {
			info[++A]=item;
			System.out.println("Pushed Succesfully ....");
			++B;
		}
		}
		public void pop()
		{
			if(B== -1) {
				System.out.println("Queue Underflow");
			}
			else {
				System.out.println("PopedSuccesfully - "+info[B--]);
				A--;

			}
		}
		public void searchQueue(int item)
		{
			int position=Arrays.binarySearch(info, item);
			if(position>=0)
				System.out.println("item found at "+position+" position");
			else
				System.out.println("item not found.");
		}

		public int[] displayQueue()
		{
			return info;
		}

	}


