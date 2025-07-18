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

import com.example.demo.entity.Librarian;
import com.example.demo.service.LibrarianService;

@RestController
@RequestMapping("api/librarian")
public class LibrarianController {
	private LibrarianService librarianService;
	
	public LibrarianController(LibrarianService librarianService) {
		super();
		this.librarianService = librarianService;
	}

	@PostMapping
	public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
	    Librarian savedLibrarian = librarianService.createLibrarian(librarian);
	    return new ResponseEntity<>(savedLibrarian, HttpStatus.CREATED);
	}
	
	@GetMapping("/{librarianId}")
	public ResponseEntity<Librarian> getLibrarianById(@PathVariable("librarianId") Integer librarianId) {
	    Librarian librarian = librarianService.getLibrarianById(librarianId);
	    return new ResponseEntity<>(librarian, HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<Librarian>> getAllLibrarian() {
        List<Librarian> librarianList = librarianService.getAllLibrarian();
        return new ResponseEntity<List<Librarian>>(librarianList, HttpStatus.OK);
    }
	
	@PutMapping("/{librarianId}")
	public ResponseEntity<Librarian> updateLibrarian(@PathVariable Integer librarianId, @RequestBody Librarian librarian) {
		librarian.setLibrarianId(librarianId);
		Librarian updatedLibrarian = librarianService.updateLibrarian(librarian);
		
		return new ResponseEntity<Librarian>(updatedLibrarian, HttpStatus.OK);
	}
	
	@DeleteMapping("/{librarianId}")
	public void deleteBook(@PathVariable("librarianId") Integer librarianId) {
	    librarianService.deleteLibrarian(librarianId);
	}
}
