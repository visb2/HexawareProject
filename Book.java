package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	@Column(nullable=false)
	private String bookName;
	@Column(nullable=false)
	private String bookAuthor;
	private String bookGenre;
	@Column(nullable=false)
	private int available_copies;
	
	// Default Constructor
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public Book(int bookId, String bookName, String bookAuthor, String bookGenre, int available_copies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.available_copies = available_copies;
	}
	
	// Getters and Setters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public int getAvailable_copies() {
		return available_copies;
	}
	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}
	
}
