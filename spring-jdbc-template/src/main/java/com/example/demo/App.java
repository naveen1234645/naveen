package com.example.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.MyConfig;
import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoImpl;
import com.example.demo.model.Book;

public class App {

	public static void main(String[] args) {

		try {
			@SuppressWarnings("resource")
			ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
			BookDao bookDao = context.getBean("bookDaoImpl", BookDaoImpl.class);
			Book book=bookDao.createBook(new Book(101, "Learning Spring", 75.0));
			System.out.println(book);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}