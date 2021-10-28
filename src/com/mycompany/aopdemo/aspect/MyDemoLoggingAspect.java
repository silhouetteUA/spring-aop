package com.mycompany.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.mycompany.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //combine pointcut
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

    //here  we add all of our related advices for logging

    //@Before(value = "execution(public void addAccount())")
    //@Before(value = "execution(public void com.mycompany.aopdemo.dao.addAccount())")
    //@Before(value = "execution(public void add*())")
    //@Before(value = "execution(* add*())")
    //@Before(value = "execution(* add*(com.mycompany.aopdemo.Account))")
    //@Before(value = "execution(* add*(com.mycompany.aopdemo.Account, ..))")
    //@Before(value = "execution(* add*(..))")
    //@Before(value = "execution(* com.mycompany.aopdemo.dao.*.*(..))")
    //@Before("forDaoPackage()")
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("=====> Executing @Before advice on addAccount");
    }


}
