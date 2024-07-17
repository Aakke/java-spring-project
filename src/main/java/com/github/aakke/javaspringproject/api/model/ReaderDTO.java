package com.github.aakke.javaspringproject.api.model;

import java.util.Objects;
import java.util.Set;

public record ReaderDTO(long id, String firstName, String lastName, int birthYear, String address, Set<Long> readBooks) {
    
    public ReaderDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(birthYear);
        Objects.requireNonNull(address);
        // Books can be null/Empty set if no books are read.
    }
}
