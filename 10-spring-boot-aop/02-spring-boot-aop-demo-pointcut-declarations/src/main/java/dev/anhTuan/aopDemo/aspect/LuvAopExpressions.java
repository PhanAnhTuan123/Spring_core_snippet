package dev.anhTuan.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution( * dev.anhTuan.aopDemo.dao.*.*(..))")
    protected void forDaoPackage(){}

    //create a pointcut for getter methods
    @Pointcut("execution(* dev.anhTuan.aopDemo.dao.*.get*(..)))")
    protected void getter(){}
    //create a pointcut for setter methods
    @Pointcut("execution(* dev.anhTuan.aopDemo.dao.*.set*(..))")
    protected void setter(){}
    //create pointcut: include package .. exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    protected void forDaoPackageNoGetterSetter(){}


}
