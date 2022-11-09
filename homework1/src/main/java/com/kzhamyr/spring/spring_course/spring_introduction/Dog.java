/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.spring_course.spring_introduction;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet{
    public Dog(){
        System.out.println("Dog been is created");
    }
    @Override
    public void say(){
        System.out.println("Bow-wow");
    }
}
