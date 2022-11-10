/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kzhamyr.spring.homework3.TestOnetoMany;

import com.kzhamyr.spring.homework3.TestOnetoMany.entity.Department;
import com.kzhamyr.spring.homework3.TestOnetoMany.entity.Employee;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestInsert {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("department_name: ");
            String depart_name = sc.next();
            System.out.println("maxsalary: ");
            int maxsalary = sc.nextInt();
            System.out.println("minsalary: ");
            int minsalary = sc.nextInt();
            System.out.println("Name first employee: ");
            String name_first = sc.next();
            System.out.println("Surname first employee: ");
            String surname_first = sc.next();
            System.out.println("Salary first employee: ");
            int salary_first = sc.nextInt();
            System.out.println("Name two employee: ");
            String name_two = sc.next();
            System.out.println("Surname two employee: ");
            String surname_two = sc.next();
            System.out.println("Salary two employee: ");
            int salary_two = sc.nextInt();
            
            session = factory.getCurrentSession();
            Department dep = new Department(depart_name, maxsalary, minsalary);
            Employee emp1 = new Employee(name_first, surname_first, salary_first);
            Employee emp2 = new Employee(name_two, surname_two, salary_two);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
            System.out.println("Объекты класса Department и Employee внесены в БД");
        } finally {
            session.close();
            factory.close();
        }
    }
}
