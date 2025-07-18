package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Librarian;

public interface LibrarianService {
	Librarian createLibrarian(Librarian librarian);
	List<Librarian> getAllLibrarian(); 
	Librarian getLibrarianById(Integer librarianId); 
	Librarian updateLibrarian(Librarian librarian); 
	void deleteLibrarian(Integer librarianId); 
}
