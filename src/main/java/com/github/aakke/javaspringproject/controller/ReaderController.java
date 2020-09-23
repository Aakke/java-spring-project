package com.github.aakke.javaspringproject.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aakke.javaspringproject.model.Reader;
import com.github.aakke.javaspringproject.service.ReaderService;

@RestController // Spring Rest Controller.
@RequestMapping("/api")
public class ReaderController {

	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/reader/{id}")//, produces = "application/json")
	public ResponseEntity<Reader> getReader(@PathVariable int id) {
		return ResponseEntity.ok().body(readerService.findById(id));
	}
	
	@GetMapping("/readers")
	public Collection<Reader> getAllReaders() {
		return readerService.findAll();
	}
}
