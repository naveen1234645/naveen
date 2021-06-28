package com.example.demo.dao;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;

@Component

public class BookDaoImpl implements BookDao {

	
	  /*private DataSource dataSource;
	  
	  public BookDaoImpl(DataSource dataSource) { super(); this.dataSource =
	  dataSource; }
	  
	  @Override public Connection getMyConnection() throws SQLException {
	  
	  Connection connection=dataSource.getConnection(); return connection; }
	 */
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Book createBook(Book book) throws SQLException {
		
		int count=jdbcTemplate.update("insert into book(book_id,book_name,book_price) values("+book.getBookId()+",'"+book.getBookName()+"',"+book.getBookPrice()+")");
		System.out.format("%d rows inserted",count);
		return book;
	}
	
	
	
	
	
	
	
	
	
	

}