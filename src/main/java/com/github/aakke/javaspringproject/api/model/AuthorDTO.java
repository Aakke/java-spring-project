package com.github.aakke.javaspringproject.api.model;

import java.util.Objects;
import java.util.Set;

public record AuthorDTO(long id, int version, String name, int birthYear, Set<Long> books) {

    public AuthorDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(version);
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthYear);
        Objects.requireNonNull(books);
    }
} 
