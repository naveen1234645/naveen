package com.example.spring_hibernate_integration.repo;

import java.io.IOException;
import java.util.List;

import com.example.spring_hibernate_integration.model.Book;

public interface BookReporitory {
	

   public Book createBook(Book book);
	
	public List<Book> getAllBook();
	
	public Book findbyId(Integer id);
	
	public void updateBook(Integer id) throws IOException;
	
	public void deleteBook(Integer id);
}