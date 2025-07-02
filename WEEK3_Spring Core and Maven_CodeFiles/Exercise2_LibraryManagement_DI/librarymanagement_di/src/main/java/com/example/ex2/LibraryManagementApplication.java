package com.example.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex2.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext2.xml");

        BookService bs = c.getBean("bookService", BookService.class);
        bs.displayBookInfo();
    }
}
