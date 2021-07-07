package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.ui.BookErrorResponse;
import com.sun.tools.javac.util.Log;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleBookNotFoundException(BookNotFoundException e) {
		BookErrorResponse response = new BookErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setErrorReportingTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleTypeMisMatchedException(Exception e) {
		BookErrorResponse response = new BookErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setErrorReportingTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		log.info("within get all method");
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBook());
	}

	@PostMapping("/api/books")
	public ResponseEntity<Book> createANewBook(@RequestBody Book book) throws Exception {
		log.info("within post mapping");
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
	}

	@GetMapping("/api/books/{id}")
	
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
	log.info("within get by id");
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}
	
	@GetMapping("/api/books/find/{bookId}")
	public ResponseEntity<Book> getBookByBookId(@PathVariable("bookId") String bookId)
	{
		log.info("within get by bookId");
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getByBookId(bookId));
	}

	@PutMapping("/api/books/{bookId}")
	public ResponseEntity<Book> updateBookByBookId(@PathVariable("bookId") String bookId,@RequestBody Book book)
	{
		log.info("within put mapping");
		Book book2=bookService.updateBookByBookId(bookId, book);
		return ResponseEntity.status(HttpStatus.OK).body(book2);
	}
	
	@DeleteMapping("/api/books/{bookId}")
	public ResponseEntity<String> deleteByBookId(@PathVariable("bookId") String bookId)
	{
		return ResponseEntity.ok(bookService.deleteByBookId(bookId));
	}
}