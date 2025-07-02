package com.example.ex8.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.ex8.service.*.*(..))")
    public void beforeAdvice() {
        System.out.println(" LoggingAspect: Before method execution.");
    }

    @After("execution(* com.example.ex8.service.*.*(..))")
    public void afterAdvice() {
        System.out.println("LoggingAspect: After method execution.");
    }
}
