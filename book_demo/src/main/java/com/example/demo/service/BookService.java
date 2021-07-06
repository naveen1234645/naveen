package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Book;

public interface BookService {
	public Book createBook(Book book);
	public Collection<Book> displayAllBook();
	public Book findById(Integer id);

}