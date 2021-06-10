

package comm.example;
public class Engineer extends Employee {
	
	private String stream;
	public Engineer() {
		super();
	}

	


	public Engineer(Integer employeeId, String firstName, String lastName, String email, EmployeeType employeeType,String stream) {
		super(employeeId, firstName, lastName, email, employeeType);
		// TODO Auto-generated constructor stub
		this.stream=stream;
	}



	@Override
	public String toString() {
		return "Engineer [stream=" + stream + ", toString()=" + super.toString() + "]";
	}
	
	
}
  s