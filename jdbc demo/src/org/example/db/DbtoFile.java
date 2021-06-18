package org.example.db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.example.model.Employee;
import org.example.dao.EmployeeDaoImpl;

public class DbtoFile {


	public void toFile(String filename) throws SQLException, IOException
	{
		EmployeeDaoImpl em=new EmployeeDaoImpl();
		File outputFile=new File(filename);
		FileWriter out=new FileWriter(outputFile);

		List<Employee> list=new ArrayList<Employee>();
		list=em.getAllEmployees();

		PrintWriter writer=new PrintWriter(out);
		Iterator<Employee> i=list.iterator();
		Employee emp2=null;
		while(i.hasNext())
		{
			emp2=i.next();
			String str1=emp2.getId()+","+emp2.getFirstName()+","+emp2.getLastName()+","+emp2.getEmail();
			writer.println(str1);

		}
		System.out.println("Details Entered to file Successfully!");
		out.close();
	}

}
