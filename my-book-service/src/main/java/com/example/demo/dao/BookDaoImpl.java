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
}