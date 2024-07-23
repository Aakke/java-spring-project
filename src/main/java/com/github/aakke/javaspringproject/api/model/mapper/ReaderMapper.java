package com.github.aakke.javaspringproject.api.model.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.api.model.ReaderDTO;
import com.github.aakke.javaspringproject.persistence.model.Reader;

@Service
public class ReaderMapper {

    public ReaderDTO toDto(final Reader pm) {

        return new ReaderDTO(
                pm.getId(),
                pm.getVersion(),
                pm.getFirstName(),
                pm.getLastName(),
                pm.getBirthYear(),
                pm.getAddress(),
                pm.getReadBooks());
    }

    public Reader toPm(final ReaderDTO dto) {

        final Reader pm = new Reader();
        pm.setId(dto.id());
        pm.setVersion(dto.version());
        pm.setLastName(dto.lastName());
        pm.setFirstName(dto.firstName());
        pm.setBirthYear(dto.birthYear());
        pm.setAddress(dto.address());
        pm.setReadBooks(dto.readBooks());
        return pm;
    }

    public List<ReaderDTO> toDtoList(final List<Reader> pmList) {
        
        return pmList.stream().map(pm -> toDto(pm)).toList();
    }
    
}
