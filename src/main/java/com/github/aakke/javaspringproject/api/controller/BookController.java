package com.github.aakke.javaspringproject.api.controller;

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

import com.github.aakke.javaspringproject.api.model.BookDTO;
import com.github.aakke.javaspringproject.api.model.mapper.BookMapper;
import com.github.aakke.javaspringproject.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;
	private final BookMapper bookMapper;
	
	@Autowired
	public BookController(final BookService service, final BookMapper bookMapper) {
		this.bookMapper = bookMapper;
		this.bookService = service;
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable final int id) {
		return ResponseEntity.ok().body(bookMapper.toDto(bookService.findById(id)));
	}
	
	@GetMapping("/books")
	public Collection<BookDTO> getAllBooks() {
		return bookMapper.toDtoList(bookService.findAll());
	}
	
	@PostMapping("/book")
	public ResponseEntity<BookDTO> newBook(@RequestBody final BookDTO newBook) {
		BookDTO book = bookMapper.toDto(bookService.create(bookMapper.toPm(newBook)));
		return ResponseEntity.ok().body(book);
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable final int id, @RequestBody final BookDTO book) {
		BookDTO updatedBook = bookMapper.toDto(bookService.update(id, bookMapper.toPm(book)));
		return ResponseEntity.ok().body(updatedBook);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable final int id) {
		// Exception thrown from persistence layer if fails.
		bookService.deleteById(id);
	}
}
