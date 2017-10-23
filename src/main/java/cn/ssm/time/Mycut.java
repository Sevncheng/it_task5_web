package cn.ssm.time;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
@Component
@Aspect
public class Mycut {
    Logger log = Logger.getLogger(Mycut.class);

    @Around("execution(* cn.ssm.service.*.*(..))")
    public Object  stime(ProceedingJoinPoint pj) throws Throwable {
        Long begin = new Date().getTime();
        Object o  = pj.proceed();
        Long end = new Date().getTime();
        log.info("本次访问db花费时间为"+(end-begin)+"毫秒");
        return o;
    }

    @Around("execution(* cn.ssm.controller.*.*(..))")
    public Object ctimeget(ProceedingJoinPoint pj) throws Throwable {
        Long begin = new Date().getTime();
        Object  o = pj.proceed();
        Long end = new Date().getTime();
        log.info("本次访问controller花费时间为"+(end-begin)+"毫秒");
        return o;
    }

}*/
