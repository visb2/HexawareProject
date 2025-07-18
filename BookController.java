package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("api/book")
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
	    Book savedBook = bookService.createBook(book);
	    return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer bookId) {
	    Book book = bookService.getBookById(bookId);
	    return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
    }
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
		book.setBookId(bookId);
		Book updatedBook = bookService.updateBook(book);
		
		return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable("bookId") Integer bookId) {
	    bookService.deleteBook(bookId);
	}
}
