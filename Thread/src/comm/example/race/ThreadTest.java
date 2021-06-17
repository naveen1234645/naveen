package comm.example.race;
public class ThreadTest {

	public static void main(String[] args) {
		//new PrintStringThread("Hello", "There");
		//new PrintStringThread("How Are", "You?");
		//new PrintStringThread("Thank You", "Very Much");
		TwoString twoString=new TwoString();
		new PrintStringThread("Hello", "There",twoString);
		new PrintStringThread("How Are", "You?",twoString);
		new PrintStringThread("Thank You", "Very Much",twoString);

	}

}