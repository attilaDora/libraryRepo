package com.example.libary.repository;

import com.example.libary.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    public Book addBook(Book book){
        books.put(book.getIsbn(), book);
            return book;
    }
    public List<Book> getAllBooks(){return new ArrayList<>(books.values());}
    public Book getByIsbn(String isbn){return books.get(isbn); }
    public Book removeBook(String isbn){return books.remove(isbn);}
}
