/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestManytoMany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.kzhamyr.spring.homework3.TestManytoMany.entity.*;
import java.util.Scanner;
import org.hibernate.Session;


public class TestInsert {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Child.class).
                addAnnotatedClass(Section.class).
                buildSessionFactory();

        Session session = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("name_section: ");
            String name_section = sc.next();
            System.out.println("name_first: ");
            String name_first = sc.next();
            System.out.println("age_first: ");
            int age_first = sc.nextInt();
            System.out.println("name_two: ");
            String name_two = sc.next();
            System.out.println("age_two: ");
            int age_two = sc.nextInt();
            System.out.println("name_three: ");
            String name_three = sc.next();
            System.out.println("age_three: ");
            int age_three = sc.nextInt();
            
            session = factory.getCurrentSession();

            Section section1 = new Section(name_section);

            Child child1 = new Child(name_first, age_first);
            Child child2 = new Child(name_two, age_two);
            Child child3 = new Child(name_three, age_three);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();
            session.save(section1);
            session.getTransaction().commit();
            System.out.println("Объекты класса Child и Section внесены в БД");
            
        }finally {
            session.close();
            factory.close();
        }
    }
}
