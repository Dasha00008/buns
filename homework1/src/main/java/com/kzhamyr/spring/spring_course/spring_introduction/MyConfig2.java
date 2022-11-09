/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.spring_course.spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig2 {
    
    @Bean
    public Pet dogBean(){
        return new Dog();
    }
    
    @Bean
    public Person personBean(){
        return new Person(dogBean());
}
}
