package com.github.aakke.javaspringproject.api.model.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.api.model.BookDTO;
import com.github.aakke.javaspringproject.persistence.model.Book;

@Service
public class BookMapper {

    public BookDTO toDto(final Book pm) {

        return new BookDTO(
                pm.getId(),
                pm.getVersion(),
                pm.getName(),
                pm.getPublished());
    }

    public Book toPm(final BookDTO dto) {

        final Book pm = new Book();
        pm.setId(dto.id());
        pm.setVersion(dto.version());
        pm.setName(dto.name());
        pm.setPublished(dto.published());
        return pm;
    }

    public List<BookDTO> toDtoList(final List<Book> pmList) {
        
        return pmList.stream().map(pm -> toDto(pm)).toList();
    }
    
}
