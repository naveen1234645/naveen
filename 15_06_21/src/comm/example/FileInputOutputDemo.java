package comm.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {

	public static void main(String[] args) throws IOException {
		File inputFile=new File("farrago.txt");
		File outputFile=new File("outagain.py");
		FileInputStream inputStream=null;
		FileOutputStream outputStream=null;
		try {
			inputStream=new FileInputStream(inputFile);
			outputStream=new FileOutputStream(outputFile);
			int c;
			try {
				while((c=inputStream.read())!=-1)
				{
					System.out.println(c);
					outputStream.write(c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		finally {
			inputStream.close();
			outputStream.close();
		}


	}

}
