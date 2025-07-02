package com.example.ex6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex6.repository.BookRepository;

@Service
public class BookService {

    private BookRepository br;

    @Autowired
    public void setBookRepository(BookRepository br) {
        this.br = br;
    }

    public void displayBookInfo() {
        System.out.println("BookService: Displaying book info...");
        br.fetchBooks();
    }
}
