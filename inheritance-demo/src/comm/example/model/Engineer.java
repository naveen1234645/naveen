package comm.example.model;
public class Engineer extends Employee{
	
	private String stream;
	public Engineer() {
		super();
		
	}
	public Engineer(String firstName, String lastName, String email, double salary,String stream) {
		super(firstName, lastName, email, salary);
		this.stream=stream;
		
	}
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+ " Stream: "+stream;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

}
