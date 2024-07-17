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

import com.github.aakke.javaspringproject.api.model.ReaderDTO;
import com.github.aakke.javaspringproject.api.model.mapper.ReaderMapper;
import com.github.aakke.javaspringproject.service.ReaderService;

@RestController // Spring Rest Controller.
@RequestMapping("/api")
public class ReaderController {

	private final ReaderService readerService;
	private final ReaderMapper readerMapper;
	
	@Autowired
	public ReaderController(ReaderService readerService, final ReaderMapper readerMapper) {
		this.readerService = readerService;
		this.readerMapper = readerMapper;
	}
	
	@GetMapping("/reader/{id}")
	public ResponseEntity<ReaderDTO> getReader(@PathVariable final int id) {
		return ResponseEntity.ok().body(readerMapper.toDto(readerService.findById(id)));
	}
	
	@GetMapping("/readers")
	public Collection<ReaderDTO> getAllReaders() {
		return readerMapper.toDtoList(readerService.findAll());
	}
	
	@PostMapping("/reader")
	public ResponseEntity<ReaderDTO> newReader(@RequestBody final ReaderDTO newReader) {
		ReaderDTO reader = readerMapper.toDto(readerService.create(readerMapper.toPm(newReader)));
		return ResponseEntity.ok().body(reader);
	}
	
	@PutMapping("/reader/{id}")
	public ResponseEntity<ReaderDTO> updateReader(@PathVariable final int id, @RequestBody final ReaderDTO reader) {
		ReaderDTO updatedReader = readerMapper.toDto(readerService.update(id, readerMapper.toPm(reader)));
		return ResponseEntity.ok().body(updatedReader);
	}
	
	@DeleteMapping("/reader/{id}")
	public void deleteReaderById(@PathVariable final int id) {
		readerService.deleteById(id);
	}
}
