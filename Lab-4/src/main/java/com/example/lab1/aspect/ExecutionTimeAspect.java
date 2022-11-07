package com.example.lab1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(com.example.lab1.aspect.annotation.ExecutionTime)")
//    @Pointcut("execution(* com.example.lab1.controller.UserController.*(..))")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = joinPoint.proceed(); // very important in case of around, makes the flow go from before to after
        long finish = System.nanoTime();
        System.out.println(joinPoint.getSignature().getName() + "takes the time of " + (finish - start) + "nanoseconds");
        return result;
    }
}
