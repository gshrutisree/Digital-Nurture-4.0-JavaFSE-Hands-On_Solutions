package com.example.ex7.service;

import com.example.ex7.repository.BookRepository;

public class BookService {
    private BookRepository br;

    public BookService(BookRepository br) {
        this.br = br;
        System.out.println("Constructor injection used.");
    }

    public void setBookRepository(BookRepository br) {
        this.br = br;
        System.out.println("Setter injection used.");
    }

    public void displayBookInfo() {
        System.out.println(" BookService: Displaying book information.");
        br.printRepositoryInfo();
    }
}





