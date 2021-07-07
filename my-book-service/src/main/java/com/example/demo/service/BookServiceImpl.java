package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		book.setBookId(UUID.randomUUID().toString());
		return bookDao.createBook(book);
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

}