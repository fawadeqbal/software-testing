package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    public void setUp() {
//        IBookRepository bookRepository = new FakeRepositoryForTest();
        IBookRepository bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor_ValidAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
//        Assertions.assertEquals(0, books.size());
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_NullAuthor() {
        List<Book> books = bookService.getBooksByAuthor(null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_EmptyAuthor() {
        List<Book> books = bookService.getBooksByAuthor("");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_CaseSensitiveAuthor() {
        List<Book> books = bookService.getBooksByAuthor("kent beck");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_ValidTitle() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
//        Assertions.assertEquals(0, books.size());
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_NullTitle() {
        List<Book> books = bookService.getBooksByTitle(null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_EmptyTitle() {
        List<Book> books = bookService.getBooksByTitle("");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_CaseSensitiveTitle() {
        List<Book> books = bookService.getBooksByTitle("clean code");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_ValidAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code");
//        Assertions.assertEquals(0, books.size());
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_ValidAuthorInvalidTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_InvalidAuthorValidTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Clean Code");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NullAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null, null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_ValidAuthorNullTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NullAuthorValidTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null, "Clean Code");
        Assertions.assertEquals(0, books.size());
    }
}