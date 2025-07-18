package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Librarian")
public class Librarian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int LibrarianId;
	@Column(nullable=false)
	private String LibrarianMail;
	@Column(nullable=false)
	private String password;
	
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Librarian(int librarianId, String librarianMail, String password) {
		super();
		this.LibrarianId = librarianId;
		this.LibrarianMail = librarianMail;
		this.password = password;
	}

	public int getLibrarianId() {
		return LibrarianId;
	}

	public void setLibrarianId(int librarianId) {
		LibrarianId = librarianId;
	}

	public String getLibrarianMail() {
		return LibrarianMail;
	}

	public void setLibrarianMail(String librarianMail) {
		LibrarianMail = librarianMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
