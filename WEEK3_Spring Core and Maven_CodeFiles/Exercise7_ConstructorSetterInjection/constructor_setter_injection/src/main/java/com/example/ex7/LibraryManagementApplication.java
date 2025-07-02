package com.example.ex7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ex7.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bs = (BookService) c.getBean("bookService");
        bs.displayBookInfo();
    }
}
