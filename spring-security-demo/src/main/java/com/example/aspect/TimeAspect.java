package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimeAspect {
    @Around("execution(* com.example.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("切片开始");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数：" + arg);
        }

        long start = new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("切片耗时:" + (new Date().getTime() - start));

        System.out.println("切片结束");

        return object;
    }
}
