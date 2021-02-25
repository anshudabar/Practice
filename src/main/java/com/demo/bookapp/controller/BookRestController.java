package com.demo.bookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookapp.dao.Book;
import com.demo.bookapp.service.BookService;

@RestController
public class BookRestController {
	
	
	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@GetMapping(path = "book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> allbooks() {
		List<Book> allBooks = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}
	
	@GetMapping(path = "book/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookById(@PathVariable(name = "id") int bookId){
		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	
	@PostMapping(path = "book",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
		bookService.addBook(book);
		return new ResponseEntity<Book>(book,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping(path = "book/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> deleteBook(@PathVariable(name = "id") int bookId){
		Book bookToDelete = bookService.getBookById(bookId);
		bookService.removeBook(bookId);
		return new ResponseEntity<Book>(bookToDelete,HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping(path = "book/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable(name = "id") int bookid,@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.updateBook(bookid, book),HttpStatus.OK);
	}
}






