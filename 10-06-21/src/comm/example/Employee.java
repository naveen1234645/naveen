package comm.example;
public class Employee {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private EmployeeType employeeType;
	public static int max=10;
	public Employee() {
		super();
	}
	public Employee(Integer employeeId, String firstName, String lastName, String email,EmployeeType employeeType) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeType=employeeType;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
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
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email +"," + email + " Employee Type= "+employeeType +"]";
	}
s

}