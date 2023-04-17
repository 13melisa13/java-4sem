package com.example.task1424;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around(value = "allServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed for " + executionTime + " mc");
        return proceed;
    }
    @Pointcut(value = "within(com.example.task1424.services.*)")
    public void allServiceMethods() {}
}
