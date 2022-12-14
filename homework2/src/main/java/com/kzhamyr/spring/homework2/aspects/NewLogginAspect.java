package com.kzhamyr.spring.homework2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLogginAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookAdvice: В библиотеку пытаются вернуть книгу.");
        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println("aroundReturnBookAdvice: было поймано исключение " + e);
            throw e;
            //targetMethodResult = "Неизвестное название книги";
        }
        long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookAdvice: В библиотеку успешно вернули книгу.");
        System.out.println("aroundReturnBookAdvice: метод returnBook выполнил работу за " + (end - begin) + " миллисекунд");
        return targetMethodResult;
    }
}
