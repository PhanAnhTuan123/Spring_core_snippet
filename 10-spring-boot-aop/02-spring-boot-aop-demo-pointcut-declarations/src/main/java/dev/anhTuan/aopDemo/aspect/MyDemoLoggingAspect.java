package dev.anhTuan.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect extends LuvAopExpressions{

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void add*())")

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");

    }







}
