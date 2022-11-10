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

public class TestDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Child.class).
                addAnnotatedClass(Section.class).
                buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Section section = session.get(Section.class, 3);
            session.delete(section);
            session.getTransaction().commit();
            
            System.out.println("Объекты класса Section с id=3 и Child были удалены");
            
        }finally {
            session.close();
            factory.close();
        }
    }
}
