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
		String[] str=UUID.randomUUID().toString().split("-");
		book.setBookId(str[0]);
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

	@Override
	public Book getByBookId(String id) {
		// TODO Auto-generated method stub
		return bookDao.getByBookId(id);
	}

	@Override
	public Book updateBookByBookId(String bookId,Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBookByBookId(bookId, book);
	}

	@Override
	public String deleteByBookId(String bookId) {
		
		return bookDao.deleteByBookId(bookId);
	}

}