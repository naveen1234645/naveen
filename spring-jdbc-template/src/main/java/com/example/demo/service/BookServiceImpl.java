package com.example.demo.service;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDaoImpl;

	@Autowired
	public BookServiceImpl(BookDao bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	@Override
	public Book createBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		return bookDaoImpl.createBook(book);
	}

	@Override
	public List<Book> displayAllBook() throws SQLException {
		// TODO Auto-generated method stub
		return bookDaoImpl.displayAllBook();
	}

}