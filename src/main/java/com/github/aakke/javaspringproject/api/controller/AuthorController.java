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

import com.github.aakke.javaspringproject.persistence.model.Author;
import com.github.aakke.javaspringproject.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {
	
	private final AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable final int id) {
		return ResponseEntity.ok().body(authorService.findById(id));
	}
	
	@GetMapping("/authors")
	public Collection<Author> getAllAuthors() {
		return authorService.findAll();
	}
	
	@PostMapping("/author")
	public ResponseEntity<Author> newAuthor(@RequestBody final Author newAuthor) {
		Author author = authorService.create(newAuthor);
		return ResponseEntity.ok().body(author);
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable final int id, @RequestBody final Author author) {
		Author updatedAuthor = authorService.update(id, author);
		return ResponseEntity.ok().body(updatedAuthor);
	}
	
	@DeleteMapping("/author/{id}")
	public void deleteAuthorById(@PathVariable final int id) {
		authorService.deleteById(id);
	}
}
