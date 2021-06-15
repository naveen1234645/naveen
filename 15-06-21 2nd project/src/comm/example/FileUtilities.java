package comm.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtilities {

	public static void main(String args[]) throws IOException {
		/*
		 * String fileName = "myfile.txt";
		 * 
		 * String fileName2="output.txt"; try { File f = new File(fileName); File f1=new
		 * File(fileName2); // f.createNewFile();
		 * 
		 * System.out.println(f.getName()); System.out.println(f.canRead());
		 * System.out.println(f.canWrite()); System.out.println(f.length());
		 * System.out.println(f.exists());
		 * 
		 * FileReader reader = new FileReader(f); FileWriter writer=new FileWriter(f1);
		 * // PrintWriter out=new PrintWriter(writer); BufferedReader bufferedReader =
		 * new BufferedReader(reader); String line = null; while (((line =
		 * bufferedReader.readLine()) != null)) {
		 * 
		 * System.out.println(line); writer.write(line); }
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */

		// java Tester a b
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);

		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);

		BufferedReader inputStream = new BufferedReader(in);
		PrintWriter outputStream = new PrintWriter(out);

		String l;
		while ((l = inputStream.readLine()) != null) {
			System.out.println(l);
			outputStream.println(l);
			// outputStream.write(l);
		}

		in.close();
		out.close();
	}
}