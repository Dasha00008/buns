package com.kzhamyr.spring.homework2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import com.kzhamyr.spring.homework2.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    @Pointcut("execution(*  com.kzhamyr.spring.homework2.UniLibrary.get* ())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(*  com.kzhamyr.spring.homework2.UniLibrary.return* ())")
    private void allReturnMethodsFromUniLibrary(){}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLogicAdvice(){
        System.out.println("beforeGetLogicAdvice: запись в Лог №1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLogicAdvice(){
        System.out.println("beforeReturnLogicAdvice: запись в Лог №2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLogicAdvice(){
        System.out.println("beforeGetAndReturnLogicAdvice: запись в Лог №3");
    }


    @Before(" com.kzhamyr.spring.homework2.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for(Object obj: arguments){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            "; автор - " + myBook.getAuthor() +
                            "; год издания - " + myBook.getYearOfPublication());
                }
                else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавил " + obj);
                }
            }

        }

        System.out.println("beforeAddLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("------------------------------------------------------");
    }
}
