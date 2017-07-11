package com.kaishengit.aop;

import com.kaishengit.service.Application;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Repository;


/**
 * Created by gedmk on 2017/7/10.
 */
@Repository
public class AopAspect {

//    通知类
    /*//前置通知
    public void before() {
        System.out.println("这是前置通知。。。");
    }
    //后置通知
    public void afterReturningAdvice(Object obj) {
        System.out.println("这是后置通知：" + obj);

    }

    //最终通知
    public void afterAdvice() {
        System.out.println("这是最终了");
    }*/
    //环绕通知
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("around before");
            Object result = proceedingJoinPoint.proceed(); //代表目标对象方法的执行
            System.out.println("around after returning");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around throwing");
        } finally {
            System.out.println("around after");
        }
    }



}
