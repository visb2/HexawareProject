package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	Book createBook(Book book); // Creating a new Book table with a book record
	List<Book> getAllBooks(); // Shows all the book records in the table
	Book getBookById(Integer bookId); // Shows the book based on the id
	Book updateBook(Book book); // Updates the specified book record
	void deleteBook(Integer bookId); // Deletes the book based on the bookId
}
