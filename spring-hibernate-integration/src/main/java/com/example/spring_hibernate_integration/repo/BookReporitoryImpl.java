package com.example.spring_hibernate_integration.repo;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.spring_hibernate_integration.model.Book;


@Repository
@EnableTransactionManagement
@Transactional


public class BookReporitoryImpl implements BookReporitory {
	private SessionFactory sessionFactory;
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
	
	@Autowired
	public BookReporitoryImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		System.out.println(sessionFactory);
	}
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(book);
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.openSession();
		Query query=currentSession.createQuery("select B from Book B",Book.class);
		return query.getResultList();	}

	@Override
	public Book findbyId(Integer id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		return session.get(Book.class, id);
	}

	@Override
	public void updateBook(Integer id) throws IOException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	   // session.get(Book.class, id);
	    Book book =  session.get(Book.class, id);
	    if(book==null)
	    {
	    	throw new BookNotFoundException("Book not found");
	    }
		System.out.print("Book Name: ");
		String bookName=bufferedReader.readLine();
		book.setBookName(bookName);
		System.out.println("Book Price: ");
		double bookPrice=Double.parseDouble(bufferedReader.readLine());
		book.setBookPrice(bookPrice);
		session.update(book);
	}

	@Override
	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Book delBook = session.get(Book.class, id);
		if(delBook==null)
		{
			throw new BookNotFoundException("Book not found");
		}
		session.remove(delBook);
	}

	
}