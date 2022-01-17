package com.github.aakke.javaspringproject.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aakke.javaspringproject.model.Book;
import com.github.aakke.javaspringproject.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;
	
	@Autowired
	public BookController(final BookService service) {
		this.bookService = service;
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable final int id) {
		return ResponseEntity.ok().body(bookService.findById(id));
	}
	
	@GetMapping("/books")
	public Collection<Book> getAllBooks() {
		return bookService.findAll();
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> newBook(@RequestBody final Book newBook) {
		Book book = bookService.create(newBook);
		return ResponseEntity.ok().body(book);
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable final int id, @RequestBody final Book book) {
		Book updatedBook = bookService.update(id, book);
		return ResponseEntity.ok().body(updatedBook);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable final int id) {
		// Exception thrown from persistence layer if fails.
		bookService.deleteById(id);
	}
}
