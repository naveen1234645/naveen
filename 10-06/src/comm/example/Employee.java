package comm.example;

public class Employee {

	private Integer EmployeeId;
	private String FristName;
	private String LastName;
	private String email;
	public Employee() {
		super();
		
	}
	
	public Employee(Integer employeeId, String fristName, String lastName, String email) {
		super();
		EmployeeId = employeeId;
		FristName = fristName;
		LastName = lastName;
		this.email = email;
	}

	
	public Integer getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}

	public String getFristName() {
		return FristName;
	}

	public void setFristName(String fristName) {
		FristName = fristName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", FristName=" + FristName + ", LastName=" + LastName + ", email="
				+ email + "]";
	}
	
	
	
}
