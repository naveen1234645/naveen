package org.example.db;


	import java.util.List;

	import org.example.model.Employee;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;

	public class Database {




		public List<Employee> createFromFile(String file1) throws IOException
		{
			
				List<Employee> list=new ArrayList<Employee>();
				File file=new File(file1);
				FileReader fileReader=new FileReader(file);
				BufferedReader reader=new BufferedReader(fileReader);
				String line;
				while((line=reader.readLine())!=null)
				{
					String[] str=line.split(",");
					Employee employee=new Employee();
					employee.setFirstName(str[0]);
					employee.setLastName(str[1]);
					employee.setEmail(str[2]);
					list.add(employee);
					
					
				}
				reader.close();
				return list;
		}
	}


