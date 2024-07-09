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
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepo;

	@Autowired
	public AuthorServiceImpl(final AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
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
		return authorRepo.save(newAuthor);
	}

	@Override
	public List<Author> createBatch(List<Author> authors) {
		final List<Author> toBeCreatedAuthors = authors.stream()
				.filter(author -> Objects.nonNull(author))
				.toList();

		final List<Author> createdAuthors = (List<Author>) authorRepo.saveAll(toBeCreatedAuthors);
		return createdAuthors;
	}

	@Override
	public Author update(long id, Author updateAuthor) {
		return authorRepo.save(updateAuthor);
	}

}
