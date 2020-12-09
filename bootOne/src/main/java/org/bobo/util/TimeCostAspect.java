package org.bobo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect   //定义一个切面
@Configuration
public class TimeCostAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimeCostAspect.class);

    @Pointcut("execution(* org.bobo.controller..*.*(..)) " )
    public void ruleExecute() {}

    @Around("ruleExecute()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Exception {
        long start = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("执行统计耗时切面方法出错",e);
            Exception exception = (Exception) e;
            throw exception;
        }
        //获取执行的方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        long end = System.currentTimeMillis();
        logger.info(methodName + "  cost :" + (end - start) + "ms");
        return obj;
    }
}
