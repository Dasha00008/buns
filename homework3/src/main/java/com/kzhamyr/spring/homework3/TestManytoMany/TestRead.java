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

public class TestRead {
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
            Section section1 = session.get(Section.class, 3);
            System.out.println("Объекты child и section получены из БД:");
            System.out.println(section1);
            System.out.println(section1.getChildren());
            
            

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
