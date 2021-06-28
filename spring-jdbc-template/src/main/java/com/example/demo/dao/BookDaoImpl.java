package com.example.demo.dao;

import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.BookRowMapper;

@Repository
public class BookDaoImpl implements BookDao{

	private JdbcTemplate jdbcTemplate;
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Book createBook(Book book) {
		int count=jdbcTemplate.update("insert into book(book_id,book_name,book_price) values(?,?,?)",book.getBookId(),book.getBookName(),book.getBookPrice());
		System.out.format("%d rows inserted",count);
		return book;
		
	}


	@Override
	public List<Book> displayAllBook() {
		List<Book> books=jdbcTemplate.query("select * from book",new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}


	@Override
	public List<Book> findBookById(int id) {
		List<Book> list=jdbcTemplate.query("select * from book where book_id='"+id+"'",new BookRowMapper());
			
		
		return list;
	}


	@Override
	public Book updateBookById(int id) throws BookNotFoundException, NumberFormatException, IOException {
		List<Book> list=jdbcTemplate.query("select * from book where book_id='"+id+"'",new BookRowMapper());
		Book book=null;
		if (list.isEmpty())

			throw new BookNotFoundException("book with the given id not found.");
		else
		{
			
			Iterator<Book> i=list.iterator();
			while(i.hasNext())
			{
				book=i.next();
				
			}
			
			System.out.println("Enter the new book name");
			String newName=bufferedReader.readLine();
			System.out.println("Enter the new price");
			Double newPrice=Double.parseDouble(bufferedReader.readLine());
			
			book.setBookName(newName);
			book.setBookPrice(newPrice);
			int count=jdbcTemplate.update("update book set book_name=?,book_price=? where book_id=?",book.getBookName(),book.getBookPrice(),book.getBookId());
			System.out.format("%d rows updated",count);
		}
		return book;
	}


	@Override
	public void deleteBook(int id) throws BookNotFoundException {
		List<Book> list=jdbcTemplate.query("select * from book where book_id='"+id+"'",new BookRowMapper());
		
		if (list.isEmpty())

			throw new BookNotFoundException("book with the given id not found.");
		else
		{
			Book book=list.get(0);
		
			int count=jdbcTemplate.update("delete from book where book_id=?",book.getBookId());
			
			System.out.format("%d rows successfully deleted",count);
		}
	}

	/*
	 * @Override public Connection getMyConnection() throws SQLException {
	 * Connection connection=dataSource.getConnection();
	 * 
	 * return connection; }
	 */

}