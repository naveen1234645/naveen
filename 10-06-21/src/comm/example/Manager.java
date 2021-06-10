package comm.example;
public class Manager extends Employee {
	private String departmentName;
	public Manager() {
		super();
	}

	


	public Manager(Integer employeeId, String firstName, String lastName, String email, EmployeeType employeeType,String departmentName) {
		super(employeeId, firstName, lastName, email, employeeType);
		this.departmentName=departmentName;

	}



	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Manager [departmentName=" + departmentName + ", toString()=" + super.toString() + "]";
	}
	
	
}