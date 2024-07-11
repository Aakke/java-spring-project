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

import com.github.aakke.javaspringproject.persistence.model.Reader;
import com.github.aakke.javaspringproject.service.ReaderService;

@RestController // Spring Rest Controller.
@RequestMapping("/api")
public class ReaderController {

	private final ReaderService readerService;
	
	@Autowired
	public ReaderController(ReaderService readerService) {
		this.readerService = readerService;
	}
	
	@GetMapping("/reader/{id}")
	public ResponseEntity<Reader> getReader(@PathVariable final int id) {
		return ResponseEntity.ok().body(readerService.findById(id));
	}
	
	@GetMapping("/readers")
	public Collection<Reader> getAllReaders() {
		return readerService.findAll();
	}
	
	@PostMapping("/reader")
	public ResponseEntity<Reader> newReader(@RequestBody final Reader newReader) {
		Reader reader = readerService.create(newReader);
		return ResponseEntity.ok().body(reader);
	}
	
	@PutMapping("/reader/{id}")
	public ResponseEntity<Reader> updateReader(@PathVariable final int id, @RequestBody final Reader reader) {
		// TODO: eTag/If-match headers.
		Reader updatedReader = readerService.update(id, reader);
		return ResponseEntity.ok().body(updatedReader);
	}
	
	@DeleteMapping("/reader/{id}")
	public void deleteReaderById(@PathVariable final int id) {
		readerService.deleteById(id);
	}
}
