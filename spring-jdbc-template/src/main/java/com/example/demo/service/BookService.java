package com.example.demo.service;
import java.io.IOException;
import java.sql.SQLException;
import com.example.demo.BookNotFoundException;
import java.util.List;

import com.example.demo.model.Book;

public interface BookService {

	public Book createBook(Book book);
	public List<Book> displayAllBook();
	public List<Book> findBookById(int id);
	public Book updateBookById(int id) throws BookNotFoundException, NumberFormatException, IOException;
	public void deleteBook(int id) throws BookNotFoundException;
}