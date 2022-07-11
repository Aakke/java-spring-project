package com.github.aakke.javaspringproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.aakke.javaspringproject.model.Reader;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long>{

}
