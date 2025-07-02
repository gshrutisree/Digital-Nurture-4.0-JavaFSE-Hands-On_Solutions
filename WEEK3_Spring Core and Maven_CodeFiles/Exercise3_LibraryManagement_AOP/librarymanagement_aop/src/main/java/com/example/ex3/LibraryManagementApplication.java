package com.example.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex3.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService bs = context.getBean("bookService", BookService.class);
            bs.displayBookInfo();
        }
    }
}
