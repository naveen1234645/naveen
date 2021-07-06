package com.example.demo.dao;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;

@Component
public class BookDaoImpl implements BookDao {

	private Map<Integer,Book> bookMap;

	@Autowired
	public BookDaoImpl(Map<Integer, Book> bookMap) {
	
		this.bookMap = bookMap;
		bookMap.put(new Random().nextInt(100), new Book(UUID.randomUUID().toString(), "Node JS", 20.9));
		bookMap.put(new Random().nextInt(100), new Book(UUID.randomUUID().toString(), "ReactJS", 29.9));
		bookMap.put(new Random().nextInt(100), new Book(UUID.randomUUID().toString(), "Angular JS", 29.7));
		bookMap.put(new Random().nextInt(100), new Book(UUID.randomUUID().toString(), "Pro Spring", 30.8));
		bookMap.put(new Random().nextInt(100), new Book(UUID.randomUUID().toString(), "Pro Java", 23.8));
		
	}




	@Override
	public Collection<Book> displayAllBook() {
		// TODO Auto-generated method stub
		System.out.println(bookMap);
		return bookMap.values();
	}




	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		book.setBookId(UUID.randomUUID().toString());
		bookMap.put(new Random().nextInt(1000), book);
		return book;
	}




	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return bookMap.get(id);
	}

}