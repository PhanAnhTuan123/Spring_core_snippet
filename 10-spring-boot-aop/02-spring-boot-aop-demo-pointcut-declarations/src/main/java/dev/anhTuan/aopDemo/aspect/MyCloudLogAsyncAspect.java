package dev.anhTuan.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect extends LuvAopExpressions{
    @Before("dev.anhTuan.aopDemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void logtoCloudAsync(){
        System.out.println("\n========>>> Logging to Cloud in async fashion");
    }

}
