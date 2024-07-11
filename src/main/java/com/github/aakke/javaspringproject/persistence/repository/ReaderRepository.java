package com.github.aakke.javaspringproject.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.aakke.javaspringproject.persistence.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long>{

}
