package com.github.aakke.javaspringproject.api.model;

import java.util.Objects;

public record BookDTO(long id, int version, String name, int published) {

    public BookDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(version);
        Objects.requireNonNull(name);
        Objects.requireNonNull(published);
    }
} 
