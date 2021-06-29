package com.example.spring_hibernate_integration.service;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.spring_hibernate_integration.model.Book;
import com.example.spring_hibernate_integration.repo.BookReporitory;


@Service

public class BookServiceImpl implements BookService {

	@Autowired
	BookReporitory bookrep;
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookrep.createBook(book);
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookrep.getAllBook();
	}

	@Override
	public Book findbyId(Integer id) {
		// TODO Auto-generated method stub
		return bookrep.findbyId(id);
	}

	@Override
	public void updateBook(Integer id)throws IOException {
		// TODO Auto-generated method stub
		bookrep.updateBook(id);
	}

	@Override
	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		bookrep.deleteBook(id);
	}

}