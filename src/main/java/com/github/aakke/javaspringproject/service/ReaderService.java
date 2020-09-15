package com.github.aakke.javaspringproject.service;

import java.util.List;

import com.github.aakke.javaspringproject.model.Reader;

public interface ReaderService {
	
	/**
	 * Get reader.
	 */
	void getReader();
	
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
}
