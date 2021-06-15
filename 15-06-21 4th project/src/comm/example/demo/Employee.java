package comm.example.demo;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//marker pattern
public class Employee implements Serializable{

	private String employeeId;
	private String employeeName;
	private String employeeAddress;
	public Employee() {
		super();
	}
	public Employee(String employeeId, String employeeName, String employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + "]";
	}


}
