package comm.model;



import java.util.Scanner;

public class Password {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter password");
		String password = sc.next();
		boolean check = checkPassword(password);
		if (check) {
			System.out.println("Valid");
		} else
			System.out.println("Invalid");

	}

	public static boolean checkPassword(String password) {
		if (password.length() >= 8) {
			String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
			return password.matches(pattern);
		}
		return false;
	}

}