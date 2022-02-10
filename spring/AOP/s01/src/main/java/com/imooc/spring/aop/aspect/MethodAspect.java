package com.imooc.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuliang
 * 2022/1/28
 */
public class MethodAspect {
    public void printExecutionTime(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---------------->" + now + ":" + className + "." + methodName);
        Object[] args = joinPoint.getArgs();
        System.out.println("参数总数：" + args.length);
        for (Object object : args) {
            System.out.println("当前参数是：" + object);
        }
    }

    public void doAfter(JoinPoint joinPoint) {
        System.out.println("->->->执行后置通知");
    }

    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("-->-->执行后置返回通知");
    }

    public void doAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("--<--<执行后置异常通知");
    }
}
