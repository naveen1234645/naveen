package org.example.hibernate_set_crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.example.hibernate_set_crud.model.Student;
import org.example.hibernate_set_crud.service.StudentService;
import org.example.hibernate_set_crud.service.StudentServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App {
	private static Logger logger = Logger.getLogger("org.example.hibernate_set.App.class");

	public static void main(String[] args) {

		Student student = new Student();
		PropertyConfigurator.configure("log4j.properties");

		StudentService service = new StudentServiceImpl();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String firstName, lastName, gmail = null;
		int choice = 0;

		do {
			try {
				System.out.println("1. Create student.");
				System.out.println("2. Display All students");
				System.out.println("3. Find student By Id: ");
				System.out.println("4.Update student By Id ");
				System.out.println("5.Delete student By Id ");
				System.out.print("Enter Your Choice: ");
				choice = Integer.parseInt(bufferedReader.readLine());
				switch (choice) {
				case 1:

					System.out.print("Enter First Name: ");
					firstName = bufferedReader.readLine();
					student.setFirstName(firstName);
					System.out.print("Enter Last Name: ");
					lastName = bufferedReader.readLine();
					student.setLastName(lastName);
					System.out.print("Enter gmail: ");
					gmail = bufferedReader.readLine();
					student.setGmail(gmail);
					Set<String> set = student.getImages();
					System.out.println("How many images want to enter");
					int id = Integer.parseInt(bufferedReader.readLine());
					for (int i = 0; i < id; i++) {
						System.out.println("Enter image name" + id);
						String image1 = bufferedReader.readLine();
						set.add(image1);
					}
					student.setImages(set);
					logger.info("done");
					student = service.createStudent(student);
					System.out.println(student);

					break;
				case 2:
					List<Student> list = service.displayAllStudents();
					Iterator<Student> iterator = list.iterator();
					while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}

					break;

				case 3:
					System.out.print("Enter id: ");
					id = Integer.parseInt(bufferedReader.readLine());
					student = service.findById(id);
					if (student == null) {
						logger.info("No Such student found.");
					} else {
						System.out.println("Student found: " + student);
					}

					break;
				case 4:
					try {
						System.out.println("Enter id");
						int id1 = Integer.parseInt(bufferedReader.readLine());
						student = service.updateById(id1);

						logger.info("Updated..");
					} catch (StudentNotFoundException e) {

						System.err.println(e.getMessage());
					}
					break;
				case 5:
					try {
						System.out.println("Enter id");
						int id2 = Integer.parseInt(bufferedReader.readLine());
						service.deleteById(id2);
						logger.info("Deleted..");
					} catch (StudentNotFoundException e) {
						System.err.println(e.getMessage());
					}

					break;
				case 6:
					System.out.println("Exit....");
					System.exit(0);
					break;
				default:
					System.out.println("invalid choice:");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (choice != 0);

	}
}