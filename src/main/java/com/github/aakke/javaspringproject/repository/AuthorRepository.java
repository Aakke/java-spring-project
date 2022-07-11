package com.github.aakke.javaspringproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.aakke.javaspringproject.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

}
