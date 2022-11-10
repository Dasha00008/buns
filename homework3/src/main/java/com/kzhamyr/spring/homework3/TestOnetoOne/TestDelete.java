/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestOnetoOne;

import com.kzhamyr.spring.homework3.TestOnetoOne.entity.Detail;
import com.kzhamyr.spring.homework3.TestOnetoOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestDelete {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);
            session.getTransaction().commit();
            
            System.out.println("Объекты класса Employee с id=1 и Details были удалены");
        } finally {
            session.close();
            factory.close();
        }
    }
}
