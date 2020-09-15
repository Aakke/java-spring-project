package com.github.aakke.javaspringproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.aakke.javaspringproject.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
