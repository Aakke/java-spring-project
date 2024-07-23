package com.github.aakke.javaspringproject.api.model.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.api.model.AuthorDTO;
import com.github.aakke.javaspringproject.persistence.model.Author;

@Service
public class AuthorMapper {
    
    public AuthorDTO toDto(final Author pm) {

        return new AuthorDTO(
                pm.getId(),
                pm.getVersion(),
                pm.getName(),
                pm.getBirthYear(),
                pm.getBooks());
    }

    public Author toPm(final AuthorDTO dto) {

        final Author pm = new Author();
        pm.setId(dto.id());
        pm.setVersion(dto.version());
        pm.setName(dto.name());
        pm.setBirthYear(dto.birthYear());
        pm.setBooks(dto.books());
        return pm;
    }

    public List<AuthorDTO> toDtoList(final List<Author> pmList) {
        
        return pmList.stream().map(pm -> toDto(pm)).toList();
    }
}
