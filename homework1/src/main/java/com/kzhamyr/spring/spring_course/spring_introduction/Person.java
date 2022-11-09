/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.spring_course.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("personBean")
public class Person {
    private Pet pet;
    
    @Autowired
    public Person(@Qualifier("catBean") Pet pet){
        System.out.println("Person been is created");
        this.pet = pet;
    }
    
    public void callYourPet(){
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
