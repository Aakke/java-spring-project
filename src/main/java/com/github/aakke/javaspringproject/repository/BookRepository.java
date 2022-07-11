package com.github.aakke.javaspringproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.aakke.javaspringproject.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
