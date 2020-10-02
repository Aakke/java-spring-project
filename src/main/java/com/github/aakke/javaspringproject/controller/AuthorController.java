package com.github.aakke.javaspringproject.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aakke.javaspringproject.model.Author;

@RestController
@RequestMapping("/api")
public class AuthorController {
	
	// authorService.
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable int id) {
		return null;
	}
	
	@GetMapping("/authors")
	public Collection<Author> getAllAuthors() {
		return null;
	}
	
	@PostMapping("/author")
	public ResponseEntity<Author> newAuthor(@RequestBody Author newAuthor) {
		return null;
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
		return null;
	}
}
