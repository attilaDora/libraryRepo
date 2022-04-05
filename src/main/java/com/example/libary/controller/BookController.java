package com.example.libary.controller;

import com.example.libary.model.Book;
import com.example.libary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class BookController {
    private BookService service;

    public BookController(BookService service){this.service = service;}

    @GetMapping
    public List<Book> getAllBooks(){return List.of(new Book("123", "Shining"), new Book("321", "Harry Potter"), new Book("111", "Lord of The Ring"));}

    @GetMapping("allbooks")
    public List<Book> listAllBooks(){return service.getAllBooks();}

    @GetMapping(path = "{isbm}") //localhost:8080/isbm
    public Book getBookbyIsbn(@PathVariable String isbm) {
        return service.getBookByIsbn(isbm);
    }





}
