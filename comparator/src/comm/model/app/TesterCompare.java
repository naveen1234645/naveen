package comm.model.app;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Scanner;
import comm.model.Desccomparator;

import comm.model.PriorityComparator;
import comm.model.Todo;
public class TesterCompare {
	
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice =0;
		Desccomparator desccomparator=new Desccomparator();
		PriorityComparator priorityComparator=new PriorityComparator();
		Set<Todo> set= new TreeSet<Todo>(priorityComparator);


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
				System.out.print("Enter the description: ");
				String desc=scanner.next();
				System.out.print("Enter the priority: ");
				int priority=scanner.nextInt();
				set.add(new Todo(UUID.randomUUID().toString(),desc,priority));
				System.out.println("Created Sucessfully...");

				break;

			
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


		
		/*set.add(new Todo(UUID.randomUUID().toString(),"compile",3));
		set.add(new Todo(UUID.randomUUID().toString(),"Analysys",1));
		set.add(new Todo(UUID.randomUUID().toString(), "ByteCodeVerifications", 1));
		for(Todo t:set)
		{
			System.out.println(t);
		}
		//CRUD(Create-Remove-Update-Display)
		Set s1=new HashSet<>();
		s1.size();
		s1.add(7);
		
		s1.add(8);
		System.out.println(s1);
        */




	}


	}

