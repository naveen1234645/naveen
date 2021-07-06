package com.example.demo.dao;

import java.util.Collection;

import com.example.demo.model.Book;

public interface BookDao {
	public Book createBook(Book book);
	
	public Collection<Book> displayAllBook();
	
	public Book findById(Integer id);

}