package com.github.aakke.javaspringproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.aakke.javaspringproject.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
