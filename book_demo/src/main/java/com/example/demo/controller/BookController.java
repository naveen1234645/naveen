package com.example.demo.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController

public class BookController {

	private BookService bookServiceImpl;

	@Autowired
	public BookController(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@GetMapping("/api/books")
	public ResponseEntity<Collection<Book>> displayAllBook()
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.displayAllBook());
	}

	@PostMapping("/api/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bookServiceImpl.createBook(book));
	}
	@GetMapping("/api/books/{bookId}")
	public ResponseEntity<Book> findBookById(@PathVariable("bookId") Integer bookId)
	{
		return ResponseEntity.ok(bookServiceImpl.findById(bookId));
	}
}