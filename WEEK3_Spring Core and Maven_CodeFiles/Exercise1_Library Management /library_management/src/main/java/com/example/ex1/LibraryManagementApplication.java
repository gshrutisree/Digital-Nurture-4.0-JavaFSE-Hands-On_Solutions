package com.example.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex1.repository.BookRepository;
import com.example.ex1.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bs = c.getBean("bookService", BookService.class);
        BookRepository br = c.getBean("bookRepository", BookRepository.class);

        bs.displayBookInfo();
        br.fetchBooks();
    }
}
