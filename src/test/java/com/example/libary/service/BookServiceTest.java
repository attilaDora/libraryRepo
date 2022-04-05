package com.example.libary.service;

import com.example.libary.model.Book;
import com.example.libary.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    private BookRepository bookRepository = mock(BookRepository.class);
    private BookService bookService = new BookService(bookRepository);
    @Test
    void getAllBooks() {
        //GIVEN
        List<Book> books = new ArrayList<>(List.of(
                new Book("123", "Shining"),
                new Book("321", "Harry Potter")
        ));
        //WHEN
        when(bookRepository.getAllBooks()).thenReturn(books);
        //THEN
        List<Book> actual = bookService.getAllBooks();
        Assertions.assertEquals(books, actual);

    }

    @Test
    void getBookByIsbn() {
            //GIVEN
            when(bookRepository.getByIsbn("123")).thenReturn(new Book("123", "Shining"));

            //WHEN
            Book actual = bookService.getBookByIsbn("123");

            //THEN
            Book expected = new Book("123", "Shining");

            verify(bookRepository).getByIsbn("123");
            assertEquals(expected, actual);
    }

    @Test
    void removeBook() {
        //GIVEN
        when(bookRepository.removeBook("123")).thenReturn(new Book("123", "Removed Book"));

        //WHEN
        Book actual = bookService.removeBook("123");

        //THEN
        Book expected = new Book("123", "Removed Book");


        verify(bookRepository).removeBook("123");
        assertEquals(expected, actual);
    }
}