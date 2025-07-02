package com.example.ex2.service;

import com.example.ex2.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBookInfo() {
        System.out.println("BookService: Displaying book information.");
        bookRepository.fetchBooks();
    }
}
