package com.example.libary.service;

import com.example.libary.model.Book;
import com.example.libary.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository repo;

    public BookService() {
    }

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks(){return repo.getAllBooks();}
    public Book getBookByIsbn(String isbn){return repo.getByIsbn(isbn);}
    public Book removeBook(String isbn){return repo.removeBook(isbn);}
}
