package com.github.aakke.javaspringproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.model.Book;
import com.github.aakke.javaspringproject.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepo;
	
	public BookServiceImpl(final BookRepository repo) {
		this.bookRepo = repo;
	}

	@Override
	public Book findById(long id) {
		return bookRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No book found with id: " + id));
	}

	@Override
	public List<Book> findAll() {
		var allBooks = bookRepo.findAll();
		final List<Book> booksList = new ArrayList<>();
		allBooks.forEach(booksList::add);
		return booksList;
	}

	@Override
	public void deleteById(long id) {
		bookRepo.deleteById(id);
	}

	@Override
	public Book create(Book newBook) {
		return bookRepo.save(newBook);
	}

	@Override
	public List<Book> createBatch(List<Book> books) {
		final List<Book> toBeCreatedBooks = books.stream()
				.filter(book -> Objects.nonNull(book))
				.toList();

		final List<Book> createdBooks = (List<Book>) bookRepo.saveAll(toBeCreatedBooks);
		return createdBooks;
	}

	@Override
	public Book update(long id, Book updateBook) {
		final Optional<Book> existingBook = bookRepo.findById(id);
		
		if (existingBook.isPresent()) {
			return bookRepo.save(updateBook);
		} 
		else {
			throw new EntityNotFoundException("No book found with id: " + id);
		}
	}
	
}
