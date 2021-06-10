package comm.example;

public class Engineer extends Employee {

	private String stream;

	public Engineer() {
		super();
	}

	public Engineer(Integer employeeId, String firstName, String lastName, String email,String stream) {
		super(employeeId, firstName, lastName, email);
		this.stream=stream;
	}

	@Override
	public String toString() {
		return "Engineer [stream=" + stream + ", toString()=" + super.toString() + "]";
	}



}