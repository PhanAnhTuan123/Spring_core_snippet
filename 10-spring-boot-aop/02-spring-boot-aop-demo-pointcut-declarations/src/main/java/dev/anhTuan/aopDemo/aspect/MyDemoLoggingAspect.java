package dev.anhTuan.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void add*())")

    @Before("execution( * dev.anhTuan.aopDemo.dao.*.*(..))")

    public void beforeAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");


    }


}
