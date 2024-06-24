package com.github.aakke.javaspringproject.service;

import java.util.List;

import com.github.aakke.javaspringproject.model.Author;

public interface AuthorService {

	/**
	 * Find author by id.
	 * @param id author id
	 * @return author
	 */
	Author findById(long id);
	
	/**
	 * Find all authors.
	 * @return all authors
	 */
	List<Author> findAll();
	
	/**
	 * Delete author by id.
	 * @param id author id
	 */
	void deleteById(long id);
	
	/**
	 * Create new author.
	 * @param newAuthor new author
	 * @return new author
	 */
	Author create(Author newAuthor);

	/**
	 * Create batch of new authors.
	 * @param authors new authors
	 * @return created authors
	 */
	List<Author> createBatch(List<Author> authors);
	
	/**
	 * Update author by id.
	 * @param id author id
	 * @param updateAuthor updated author
	 * @return updated author
	 */
	Author update(long id, Author updateAuthor);
}
