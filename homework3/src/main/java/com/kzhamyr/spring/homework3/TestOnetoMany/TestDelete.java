/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestOnetoMany;

import com.kzhamyr.spring.homework3.TestOnetoMany.entity.Department;
import com.kzhamyr.spring.homework3.TestOnetoMany.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 1);
            System.out.println(department);
            session.delete(department);
            
            System.out.println("Объекты класса Department с id=1 и Employee были удалены");

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
