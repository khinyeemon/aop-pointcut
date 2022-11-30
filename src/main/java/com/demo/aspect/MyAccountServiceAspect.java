package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
@Component
@Aspect
public class MyAccountServiceAspect {
    @Pointcut("target(com.demo.service.MyAccountService)")
    public  void  thisMyAccountServicePointCut(){}

   // @Before("thisMyAccountServicePointCut()")
    public  void  beforeMyAccountAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter before" +
                        " advice in [%s]%n"
                ,className
                ,  joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
}
