package com.github.aakke.javaspringproject.service;

import java.util.List;

import com.github.aakke.javaspringproject.model.Reader;

public interface ReaderService {
	
	/**
	 * Find reader by id.
	 * @param id id
	 * @return reader
	 */
	Reader findById(long id);
	
	/**
	 * Find all readers.
	 * @return list of all readers
	 */
	List<Reader> findAll();
	
	/**
	 * Delete reader by its id.
	 * @param id id
	 */
	void deleteById(Long id);
	
	/**
	 * Persist new reader.
	 */
	Reader create(Reader newReader);
	
	/**
	 * Update reader.
	 */
	Reader update(int id, Reader reader);
}
