package com.example.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return new ArrayList<>();
        }
        try {
            return bookRepository.findAllBooks().stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .collect(Collectors.toList());
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Book> getBooksByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return new ArrayList<>();
        }
        try {
            return bookRepository.findAllBooks().stream()
                    .filter(book -> book.getTitle().equals(title))
                    .collect(Collectors.toList());
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Book> getBooksByAuthorAndTitle(String author, String title) {
        if ((author == null || author.isEmpty()) || (title == null || title.isEmpty())) {
            return new ArrayList<>();
        }
        try {
            return bookRepository.findAllBooks().stream()
                    .filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author))
                    .collect(Collectors.toList());
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
            return new ArrayList<>();
        }
    }
}
