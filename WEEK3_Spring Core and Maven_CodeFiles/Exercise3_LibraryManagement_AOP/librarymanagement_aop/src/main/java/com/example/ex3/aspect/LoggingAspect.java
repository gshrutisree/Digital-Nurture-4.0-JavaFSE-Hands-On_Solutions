package com.example.ex3.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.example.ex3.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long s = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long e = System.currentTimeMillis();
        System.out.println("Method " + joinPoint.getSignature().getName() +" executed in " + (e - s) + "ms");
        return res;
    }
}
