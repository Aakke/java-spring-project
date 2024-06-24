package com.github.aakke.javaspringproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.model.Author;
import com.github.aakke.javaspringproject.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	private final AuthorRepository authorRepo;
	private final BookService bookService;
	
	@Autowired
	public AuthorServiceImpl(final AuthorRepository authorRepo, final BookService bookService) {
		this.authorRepo = authorRepo;
		this.bookService = bookService;
	}

	@Override
	public Author findById(long id) {
		return authorRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No author found."));
	}

	@Override
	public List<Author> findAll() {
		var allAuthors = authorRepo.findAll();
		List<Author> listOfAuthors = new ArrayList<>();
		allAuthors.forEach(listOfAuthors::add);
		return listOfAuthors;
	}

	@Override
	public void deleteById(long id) {
		authorRepo.delete(findById(id));
	}

	@Override
	public Author create(Author newAuthor) {
		// TODO: Some validation...
		return authorRepo.save(newAuthor);
	}

	@Override
	public List<Author> createBatch(List<Author> authors) {
		final List<Author> createdAuthors = new ArrayList<>();
		authors.stream()
				.filter(author -> Objects.nonNull(author))
				.forEach(author -> {
					final var createdAuthor = authorRepo.save(author);
					createdAuthors.add(createdAuthor);
				});
		return createdAuthors;
	}

	@Override
	public Author update(long id, Author updateAuthor) {
		var author = findById(id);
		var existingAuthor = author;
		
		// TODO: Validation...
		
		return authorRepo.save(updateAuthor);
	}
	
	
}
