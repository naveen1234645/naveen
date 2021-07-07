package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
	public Book createBook(Book book);
	public List<Book> getAllBook();

}