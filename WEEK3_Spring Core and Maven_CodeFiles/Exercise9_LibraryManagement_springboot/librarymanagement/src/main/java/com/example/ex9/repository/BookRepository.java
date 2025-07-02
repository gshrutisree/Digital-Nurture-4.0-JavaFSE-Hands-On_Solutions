package com.example.ex9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex9.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
