/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.spring_course.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestConfigJava2 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        
        context.close();

//        Person person = context.getBean("personBean", Person.class);
//        person.callYourPet();
    }
}
