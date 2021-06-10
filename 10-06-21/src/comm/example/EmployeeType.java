package comm.example;

public enum EmployeeType {

	SALARIED,
	HOORLY_PAID
	SALARIED("Salaried Employee"),
	HOORLY_PAID("Hourly Paid Employee");

	private String message;

	private EmployeeType(String message)
	{
		this.message=message;
	}

	public String getMessage() {
		return message;
	}



}