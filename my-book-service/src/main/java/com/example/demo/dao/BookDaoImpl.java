package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
@Repository
@EnableTransactionManagement
public class BookDaoImpl implements BookDao{
	
	private EntityManager entityManager;
	

	@Autowired
	public BookDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Book createBook(Book book) {
		entityManager.persist(book);
		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBook() {
	
		Query query=entityManager.createQuery("SELECT B FROM Book B",Book.class);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public Book getBookById(Integer id)
	{
		Book book1= entityManager.find(Book.class, id);
		if(book1==null)
		{
			throw new BookNotFoundException("book with the given id not found.");
		}
		return book1;
	}

	@Override
	
	public Book getByBookId(String id) {
		Query query=entityManager.createQuery("SELECT B FROM Book B WHERE B.bookId=:bId",Book.class);
		query.setParameter("bId", id);
		@SuppressWarnings("unchecked")
		List<Book> list=query.getResultList();
		if(list.isEmpty())
		{
			throw new BookNotFoundException("book with the given book_id not found.");
		}
		return list.get(0);
	}

	@Override
	@Transactional
	public Book updateBookByBookId(String bookId,Book book) {
		Book book1=getByBookId(bookId);
		book1.setBookName(book.getBookName());
		book1.setBookPrice(book.getBookPrice());
		entityManager.merge(book1);
		return book1;
	}

	@Override
	@Transactional
	public String deleteByBookId(String bookId) {
		// TODO Auto-generated method stub
		
		Book book=getByBookId(bookId);
		entityManager.remove(book);
		return "deleted sucessfully";
	}
}