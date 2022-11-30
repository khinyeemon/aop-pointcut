package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {
    @Pointcut("within(com.demo.service.*)")
    public  void withinCurrencyServicePointCut(){

    }
    @Pointcut("@within(com.demo.annotation.Secured)")
    public  void  withinAnnotationCurrencyServicePointCut(){}

    @Pointcut("@target(com.demo.annotation.Secured)")
    public  void targetAnnotationCurrencyServicePointCut(){}



    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointCut(){}

    @Pointcut("args(int,int)")
    public  void argsCurrencyServicePointCut(){}

    @Pointcut("@args(com.demo.annotation.Validated)")
    public  void argsAnnotationCurrencyServicePointCut(){}

   // @Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter before" +
                        " advice in [%s]%n"
                ,className
                ,  joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
   // @Before("withinAnnotationCurrencyServicePointCut()")
    public void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter before" +
                        " advice in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
    //@Before("beanCurrencyServicePointCut()")
    public void beforeAnnotationCurrencyService(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter before" +
                        " advice in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
//    @Before("withinCurrencyServicePointCut() && argsCurrencyServicePointCut()")
    public void argsBeanCurrencyAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter before" +
                        " advice in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
   //@After("targetAnnotationCurrencyServicePointCut()")
    public void argsAnnotationCurrenyAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter after" +
                        " advice in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
    }
  //  @AfterReturning(value = "argsAnnotationCurrencyServicePointCut()",returning = "country")
    public void argsAnnotationAfterReturningCurrenyAdvice(JoinPoint joinPoint,String country){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter after returning " +
                        " advice return value:: [%s] in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                ,country
                , LocalDateTime.now());
    }
    //@AfterThrowing(value = "argsAnnotationCurrencyServicePointCut()",throwing = "e")
    public void argsAnnotationAfterThrowingCurrenyAdvice(JoinPoint joinPoint,Throwable  e){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter after throwing " +
                        " advice expection value:: [%s] in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                ,e.getClass().getSimpleName()
                , LocalDateTime.now());
    }
    @Around("targetAnnotationCurrencyServicePointCut()")
    public Object argsAnnotationCurrenyAroundAdvice(ProceedingJoinPoint joinPoint) throws  Throwable{
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.printf("%s '%s method is invoked with %s parameter after  " +
                        " advice in [%s]%n"
                ,className
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())
                , LocalDateTime.now());
        try {
            return  joinPoint.proceed();
        }catch (Throwable e){
            System.out.println("Exception has been caught");
        }
        finally {
            System.out.println("After invoking method");
        }
        return  null;
    }
}
