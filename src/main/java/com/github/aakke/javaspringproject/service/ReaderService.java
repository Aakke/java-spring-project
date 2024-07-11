package com.github.aakke.javaspringproject.service;

import java.util.List;

import com.github.aakke.javaspringproject.persistence.model.Reader;

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
	void deleteById(long id);
	
	/**
	 * Persist new reader.
	 */
	Reader create(Reader newReader);

	/**
	 * Creates batch of readers.
	 * @param readers new readers
	 * @return created readers
	 */
	List<Reader> createBatch(List<Reader> readers);
	
	/**
	 * Update reader.
	 */
	Reader update(long id, Reader reader);
}
