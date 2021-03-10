package com.github.aakke.javaspringproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.model.Author;
import com.github.aakke.javaspringproject.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	private final AuthorRepository authorRepo;
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepo) {
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
	public Author update(long id, Author updateAuthor) {
		var author = findById(id);
		
		author.setBirthYear(updateAuthor.getBirthYear());
		updateAuthor.getBooks().forEach(b -> author.addBook(b));
		author.setName(updateAuthor.getName());
		
		return authorRepo.save(author);
	}
	
	
}
