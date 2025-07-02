package com.example.ex5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex5.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext c = 
                new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService bs = c.getBean("bookService", BookService.class);
            bs.displayBookInfo();
        }
    }
}
