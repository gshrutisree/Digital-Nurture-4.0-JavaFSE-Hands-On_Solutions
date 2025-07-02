package com.example.ex6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex6.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext c =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService bs = c.getBean(BookService.class);
            bs.displayBookInfo();
        }
    }
}
