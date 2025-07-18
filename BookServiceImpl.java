package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) {
		Book existingBook = bookRepository.findById(book.getBookId()).get();
		existingBook.setBookName(book.getBookName());
		existingBook.setBookAuthor(book.getBookAuthor());
		existingBook.setBookGenre(book.getBookGenre());
		existingBook.setAvailable_copies(book.getAvailable_copies());
		
		Book updatedBookDetails = bookRepository.save(existingBook);
		return updatedBookDetails;
	}

	@Override
	public void deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> bookById = bookRepository.findById(bookId);
		return bookById.get();
	}
}
