package comm.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeServiceImpl implements EmployeeService{

	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;

	@Override
	public void createEmployeeAndSave(Employee employee) throws IOException{

		fileOutputStream=new FileOutputStream("employee.file");
		objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(employee);

	}

	@Override
	public Employee displayEmployeeFromFile()throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		fileInputStream=new FileInputStream("employee.ser");
		objectInputStream =new ObjectInputStream(fileInputStream);
		Employee e=(Employee)objectInputStream.readObject();
		return e;
	}


}