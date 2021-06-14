package com.model.example;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.model.Student;

public class App {

	public static void main(String[] args) {

		Vector<Student> vector=new Vector<Student>();
		vector.add(new Student(1, "John", 5.5));
		vector.add(new Student(2, "Marry", 5.7));
		vector.add(new Student(3, "Public", 4.9));
		System.out.println(vector);
		//enhanched for loop
		for(Student s:vector)
		{
			System.out.println(s);
		}
		//enum implementation
		Enumeration<Student> e=vector.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		//iterator implementation
		Iterator<Student> i=vector.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}


	}

}