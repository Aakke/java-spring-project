package com.github.aakke.javaspringproject.service;

import java.util.List;

import com.github.aakke.javaspringproject.model.Book;

public interface BookService {

	/**
	 * Find book by id.
	 * @param id book id
	 * @return book
	 */
	Book findById(long id);
	
	/**
	 * Find all books.
	 * @return all books
	 */
	List<Book> findAll();
	
	/**
	 * Delete book by id.
	 * @param id book id
	 */
	void deleteById(long id);
	
	/**
	 * Create new book.
	 * @param newBook new book
	 * @return new book
	 */
	Book create(Book newBook);
	
	/**
	 * Update book by id.
	 * @param id book id
	 * @param updateBook updated book
	 * @return updated book
	 */
	Book update(long id, Book updateBook);
}
