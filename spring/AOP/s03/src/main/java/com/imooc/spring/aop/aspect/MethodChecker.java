package com.imooc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuliang
 * 2022/1/28
 */
@Component // 标记当前类为组件
@Aspect // 说明当前类是切面类
public class MethodChecker {
    @Around("execution(* com.imooc..*Service.*(..))")
    // ProceedingJoinPoint是JoinPoint的升级版，在原有功能外，还可以控制目标方法是否执行
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            // 执行目标方法
            Object proceed = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long resultTime = endTime - startTime;
            if (resultTime > 1000) {
                String className = proceedingJoinPoint.getTarget().getClass().getName();
                String methodName = proceedingJoinPoint.getSignature().getName();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm mmm");
                String now = sdf.format(new Date());
                System.out.println("=====" + now + ":" + className + "." + methodName + "执行了" + resultTime + "毫秒");
            }
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("Exception message:" + throwable.getMessage());
            throw throwable;
        }
    }
}
