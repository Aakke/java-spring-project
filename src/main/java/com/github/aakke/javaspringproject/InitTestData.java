package com.github.aakke.javaspringproject;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.aakke.javaspringproject.model.Author;
import com.github.aakke.javaspringproject.model.Book;
import com.github.aakke.javaspringproject.model.Reader;
import com.github.aakke.javaspringproject.service.AuthorService;
import com.github.aakke.javaspringproject.service.BookService;
import com.github.aakke.javaspringproject.service.ReaderService;

@Component
public class InitTestData implements ApplicationRunner {
    
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ReaderService readerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        insertBooks();
        insertAuthor();
        insertReader();
    }

    private void insertBooks() {
        final var book1 = new Book();
        book1.setName("Ajan pyörä 1");
        book1.setPublished(2024);

        final var book2 = new Book();
        book2.setName("Ajan pyörä 2");
        book2.setPublished(2024);

        final var book3 = new Book();
        book3.setName("Ajan pyörä 3");
        book3.setPublished(2024);

        bookService.createBatch(List.of(book1, book2, book3));
    }

    private void insertAuthor() {
        final var author1 = new Author();
        author1.setName("Robert Jordan");
        author1.setBirthYear(1948);
        // Returns only wheel of time books that are created earlier.
        final var createdBooks = bookService.findAll();
        final List<Long> bookIds = createdBooks.stream().map(Book::getId).toList();
        author1.setBooks(new HashSet<>(bookIds));
        authorService.create(author1);
    }

    private void insertReader() {
        final var reader = new Reader();
        reader.setBirthYear(1993);
        reader.setFirstName("Aleksi");
        reader.setLastName("Tani");
        reader.setAddress("Classified");
        // Returns only wheel of time books that are created earlier.
        final var createdBooks = bookService.findAll();
        final List<Long> bookIds = createdBooks.stream().map(Book::getId).toList();
        reader.setReadBooks(new HashSet<>(bookIds));

        readerService.create(reader);
    }
}
