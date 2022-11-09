package com.kzhamyr.spring.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBefore {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary Library = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        Library.getBook();

        Library.addBook("Ivanov", book);
        Library.addMagazine();

        context.close();
    }
}
