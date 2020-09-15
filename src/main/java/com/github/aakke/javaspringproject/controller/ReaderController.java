package com.github.aakke.javaspringproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.aakke.javaspringproject.model.Reader;
import com.github.aakke.javaspringproject.service.ReaderService;

@RestController
@RequestMapping("reader")
public class ReaderController {

	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/{id}")//, produces = "application/json")
	public Reader getReader(@PathVariable int id) {
		return readerService.findById(id);
	}
}
