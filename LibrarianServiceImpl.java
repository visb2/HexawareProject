package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Librarian;
import com.example.demo.repository.LibrarianRepository;

@Service
public class LibrarianServiceImpl implements LibrarianService {
	private LibrarianRepository libRepo;
	
	public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
		super();
		this.libRepo = librarianRepository;
	}

	@Override
	public Librarian createLibrarian(Librarian librarian) {
		return libRepo.save(librarian);
	}

	@Override
	public List<Librarian> getAllLibrarian() {
		return libRepo.findAll();
	}

	@Override
	public Librarian getLibrarianById(Integer librarianId) {
		Optional<Librarian> librarianById = libRepo.findById(librarianId);
		return librarianById.get();
	}

	@Override
	public Librarian updateLibrarian(Librarian librarian) {
		Librarian existingLibrarian = libRepo.findById(librarian.getLibrarianId()).get();
		existingLibrarian.setLibrarianMail(librarian.getLibrarianMail());
		existingLibrarian.setPassword(librarian.getPassword());
		
		Librarian updatedLibrarianDetails = libRepo.save(existingLibrarian);
		return updatedLibrarianDetails;
	}

	@Override
	public void deleteLibrarian(Integer librarianId) {
		libRepo.deleteById(librarianId);
	}

}
