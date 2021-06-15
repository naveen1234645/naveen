package comm.example.demo;

import java.io.IOException;
import java.util.UUID;

public class Tester {

	public static void main(String[] args) throws IOException,ClassNotFoundException  {
		Employee employee=new Employee(UUID.randomUUID().toString(),"John","India");
		EmployeeService service=new EmployeeServiceImpl();
		service.createEmployeeAndSave(employee);
		System.out.println("Done");
		System.out.println(service.displayEmployeeFromFile());


	}

}