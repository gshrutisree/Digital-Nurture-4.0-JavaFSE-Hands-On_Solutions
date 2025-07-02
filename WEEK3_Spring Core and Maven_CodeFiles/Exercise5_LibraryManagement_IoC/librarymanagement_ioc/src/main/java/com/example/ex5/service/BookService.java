package com.example.ex5.service;

import com.example.ex5.repository.BookRepository;

public class BookService {
    private BookRepository br;

    public void setBookRepository(BookRepository br) {
        this.br = br;
    }

    public void displayBookInfo() {
        System.out.println(" BookService: Displaying book information...");
        br.fetchBooks();
    }
}
