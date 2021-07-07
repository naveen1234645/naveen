package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.ui.BookErrorResponse;

@RestController
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
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBook());
	}

	@PostMapping("/api/books")
	public ResponseEntity<Book> createANewBook(@RequestBody Book book) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
	}

	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}
	
	@GetMapping("/api/books/find/{bookId}")
	public ResponseEntity<Book> getBookByBookId(@PathVariable("bookId") String bookId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getByBookId(bookId));
	}

}