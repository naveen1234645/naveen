package comm.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import comm.model.Desccomparator;
import comm.model.PriorityComparator;
import comm.model.Todo;

@SuppressWarnings("unused")
public class Tester {


	private Set<Employee> set = null;
	private File file;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	@SuppressWarnings("unchecked")
	public Tester() throws IOException, ClassNotFoundException {
		set=new HashSet<Employee>();
		set.add(new Employee());
		set.add(new Employee(1, "John"));
		set.add(new Employee(2, "Marry"));
		file = new File("employees.ser");
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		System.out.println(objectInputStream);
		fileOutputStream=new FileOutputStream(file);
		objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(set);
		Set<Employee> set1=(Set<Employee>)objectInputStream.readObject();
		System.out.println(set1);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Tester tester=new Tester();




	}


} 