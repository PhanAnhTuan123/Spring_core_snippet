package dev.anhTuan.aopDemo.aspect;

import dev.anhTuan.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect extends LuvAopExpressions{

    @AfterThrowing(
            pointcut = "execution(* dev.anhTuan.aopDemo.dao.AccountDAO .findAccounts(..) )",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>> Executing @AfterThrowing on method: "+method);
        // log the exception
        System.out.println("\n =====> The exception is: "+theExc);

    }

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void add*())")

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = " execution( * dev.anhTuan.aopDemo.dao.AccountDAO .findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account>result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n====>>> Executing @AfterReturning on method: "+ method);
        // print out the results of the method call
        System.out.println("\n=====>>> result is: "+result);

        // let's post-process the data ... let's modify it :->

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>> result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for(Account tempAccount : result) {


            //get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAccountAdvice(JoinPoint theJoinPoint){


        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();
        //loop thre agrs
    for(Object tempArg : args){
        System.out.println(tempArg);
        if(tempArg instanceof Account){

            // downcast and print Account specific stuff
            Account theAccount =  (Account) tempArg;

            System.out.println("account name: "+theAccount.getName());
            System.out.println("account level: "+theAccount.getLevel());


        }
    }
    }







}
