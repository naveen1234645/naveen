package comm.example.model;
public class Manager extends Employee{
	private String departmentName;
	public Manager() {
		super();
		
	}
	public Manager(String firstName, String lastName, String email, double salary,String departmentName) {
		super(firstName, lastName, email, salary);
		this.departmentName=departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+" Department Name: "+departmentName;
	}
	
	
}