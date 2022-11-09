package com.kzhamyr.spring.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAround {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        System.out.println("Method main ends");
        context.close();
    }
}
