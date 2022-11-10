//package com.example.lab1.aspect;
//
//import com.example.lab1.service.LoggerService;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
//import java.awt.*;
//import java.time.Instant;
//import java.time.ZoneId;
//import java.util.logging.Logger;
//
//@Aspect
//@Component
//public class LoggerAspect {
//
//    @Autowired
//    LoggerService loggerService;
//    Logger logger = Logger.getLogger(LoggerAspect.class.getName());
//
//    @Around("execution(* com.example.lab1.controller.*.*(..))")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        Object result = null;
//        long beginTime = System.currentTimeMillis();
//        try {
//            result = joinPoint.proceed();
//        } catch ( Throwable e) {
//            e.printStackTrace();
//        }
//
//        try {
//            saveLog(joinPoint, beginTime);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public void saveLog(ProceedingJoinPoint joinPoint, long time) throws Throwable {
//        com.example.lab1.domain.Logger logger = new com.example.lab1.domain.Logger();
//        long start = System.nanoTime();
//        joinPoint.proceed();
//        long finish = System.nanoTime();
//        System.out.println(joinPoint.getSignature().getName() + " takes time of " + (finish-start));
//        logger.setTime(finish - start);
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        logger.setDate(Instant.ofEpochMilli(time).atZone(ZoneId.of("America/Chicago")).toLocalDate());
//        logger.setOperation(request.getMethod());
//        logger.setPrinciple("Principle");
//        logger.setOperation("Operation");
//        loggerService.saveLog(logger);
//    }
//
//}
