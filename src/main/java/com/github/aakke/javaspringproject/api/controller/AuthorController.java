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

import com.github.aakke.javaspringproject.api.model.AuthorDTO;
import com.github.aakke.javaspringproject.api.model.mapper.AuthorMapper;
import com.github.aakke.javaspringproject.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {
	
	private final AuthorService authorService;
	private final AuthorMapper authorMapper;
	
	@Autowired
	public AuthorController(final AuthorService authorService, final AuthorMapper authorMapper) {
		this.authorService = authorService;
		this.authorMapper = authorMapper;
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable final int id) {
		return ResponseEntity.ok().body(
				authorMapper.toDto(authorService.findById(id)));
	}
	
	@GetMapping("/authors")
	public Collection<AuthorDTO> getAllAuthors() {
		return authorMapper.toDtoList(authorService.findAll());
	}
	
	@PostMapping("/author")
	public ResponseEntity<AuthorDTO> newAuthor(@RequestBody final AuthorDTO newAuthor) {
		AuthorDTO author = authorMapper.toDto(authorService.create(authorMapper.toPm(newAuthor)));
		return ResponseEntity.ok().body(author);
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable final int id, @RequestBody final AuthorDTO author) {
		AuthorDTO updatedAuthor = authorMapper.toDto(authorService.update(id, authorMapper.toPm(author)));
		return ResponseEntity.ok().body(updatedAuthor);
	}
	
	@DeleteMapping("/author/{id}")
	public void deleteAuthorById(@PathVariable final int id) {
		authorService.deleteById(id);
	}
}
