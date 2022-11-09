package com.kzhamyr.spring.homework2;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary{

    public void getBook(){
        System.out.println("Мы берем книгу в Library ");
        System.out.println("------------------------------------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("мы возвращаем книгу в Library");
        return  "Война и мир";
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал в Library");
        System.out.println("------------------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("мы возвращаем журнал в Library");
        System.out.println("------------------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Мы добавляем книгу в Library");
        System.out.println("------------------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в Library");
        System.out.println("------------------------------------------------------");
    }
}
