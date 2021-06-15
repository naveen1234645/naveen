package comm.example;





import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;


public class Tester {

	public static void main(String args[]) throws IOException {
		File outputFile = new File(args[0]);
		FileWriter out = new FileWriter(outputFile);
		Set<Student> set = new TreeSet<Student>();
		Student s = new Student((UUID.randomUUID().toString()),"john","A");
		Student t = new Student((UUID.randomUUID().toString()),"doe","B");
		set.add(s);
		set.add(t);

		PrintWriter writer = new PrintWriter(out);
		Iterator<Student> i = set.iterator();
		Student student = null;
		while(i.hasNext())
		{
			student= i.next();

			writer.println(student);
			System.out.println(student);
		}

		writer.close();
		out.close();




	}

}