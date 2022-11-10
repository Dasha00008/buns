/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestOnetoOne;

import com.kzhamyr.spring.homework3.TestOnetoOne.entity.*;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestInsert {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("name: ");
            String name = sc.next();
            System.out.println("surname: ");
            String surname = sc.next();
            System.out.println("department: ");
            String department = sc.next();
            System.out.println("salary: ");
            int salary = sc.nextInt();
            System.out.println("city: ");
            String city = sc.next();
            System.out.println("phoneNumber: ");
            String phoneNumber = sc.next();
            System.out.println("email: ");
            String email = sc.next();

            Employee employee = new Employee(name, surname, department, salary);
            Detail detail = new Detail(city, phoneNumber, email);
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            
            System.out.println("Объекты класса Detail и Employee внесены в БД");
            
        } finally {
            session.close();
            factory.close();
        }
    }
}
