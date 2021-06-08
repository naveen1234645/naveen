package comm.example.model;
import java.util.Random;
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private double salary;
	public Employee() {
		super();
	}
	public Employee(String firstName, String lastName, String email, double salary) {
		super();
		this.employeeId=new Random().nextInt();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDetails() {
		return "ID: " + employeeId + " First Name: " + firstName + " Last Name: " + lastName + " Email: " + email;
	}
}