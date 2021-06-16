package comm.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import comm.model.Desccomparator;
import comm.model.PriorityComparator;
import comm.model.Todo;

@SuppressWarnings("unused")
public class Tester {
private static Scanner scanner=new Scanner(System.in);
	
	

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
		
		
			int choice =0;
			Tester tester=new Tester();


			do {

				System.out.println("Choose from the options below:");
				System.out.println("1. Create:");
				System.out.println("2. Remove:");
				System.out.println("3. Update:");
				System.out.println("4. Display:");
				System.out.println("0. Exit:");

				choice=scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter the id and name: ");
					String desc=scanner.next();
					System.out.print("Enter the name: ");
					int id=scanner.nextInt();
					set.add(new Employee(UUID.randomUUID().toString(),id,name));
					System.out.println("Created Sucessfully...");

					break;
				}


	 	    case 2:
	 	    	System.out.println("Enter Todo id: ");
	 			String id = scanner.next();
	 			Todo todo = null;
	 			Iterator<Todo> i = set.iterator();
	 			while(i.hasNext()) {
	 				todo = i.next();
	 				if(todo.getTodoId().equals(id)) {
	 					System.out.println("found: " + todo);
	 					set.remove(todo);
	 					System.out.println("removed.");
	 					break;
	 				}
	 				else
	 				{
	 					System.out.println("Invalid id");
	 					break;
	 				}
	 			}


				break;
			


		    case 3:
		    	System.out.println("Enter Todo id: ");
	 			String id1 = scanner.next();
	 			Todo todo1 = null;
	 			Iterator<Todo> j = set.iterator();
	 			while(j.hasNext()) {
	 				todo1 = j.next();
	 				if(todo1.getTodoId().equals(id1)) {
	 					System.out.println("found: " + todo1);
	 					set.remove(todo1);
	 				    System.out.print("Enter the description: ");
	 					String desc1=scanner.next();
	 					System.out.print("Enter the priority: ");
	 					int priority1=scanner.nextInt();
	 					set.add(new Todo(UUID.randomUUID().toString(),desc1,priority1));
	 					System.out.println("Updated Sucessfully...");
	 						break;
	 				}
	 				else
	 				{
	 					System.out.println("Invalid id");
	 				}

	 			}
	 			break;

			case 4:
				for(Todo t:set)
				{
					System.out.println(t);
				}

				break;

			case 0:

				System.out.println("Exit from System. Bye..");
				
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Choice Try Again.");
				break;			

			}	
		}while(choice!=0);



	}


} 