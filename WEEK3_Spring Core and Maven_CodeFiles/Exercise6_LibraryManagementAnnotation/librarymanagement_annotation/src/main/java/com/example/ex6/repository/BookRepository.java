package com.example.ex6.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void fetchBooks() {
        System.out.println(" BookRepository: Fetching books from the database...");
    }
}
