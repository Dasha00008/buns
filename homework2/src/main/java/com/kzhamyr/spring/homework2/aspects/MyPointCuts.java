package com.kzhamyr.spring.homework2.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {

    @Pointcut("execution(* com.kzhamyr.spring.homework2.UniLibrary._add*(..))")
    public void allAddMethods() {
    }
}
