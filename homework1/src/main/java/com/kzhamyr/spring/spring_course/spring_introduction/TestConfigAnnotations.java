/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestConfigAnnotations {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext2.xml");
//        Cat myCat = context.getBean("catBean", Cat.class);
//        myCat.say();
        
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();
    }
}
