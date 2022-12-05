package com.kzhamyr.spring.homework2.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {

    @Pointcut("execution(* com.kzhamyr.spring.homework2.UniLibrary.add*(..))")
    public void allAddMethods() {
        System.out.println("YES");
    }
}
