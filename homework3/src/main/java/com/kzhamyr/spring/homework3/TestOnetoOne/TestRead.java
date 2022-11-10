/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestOnetoOne;

import com.kzhamyr.spring.homework3.TestOnetoOne.entity.Detail;
import com.kzhamyr.spring.homework3.TestOnetoOne.entity.Employee;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRead {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 2);
            System.out.println("Объекты detail и employee получены из БД:");
            System.out.println(detail);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
