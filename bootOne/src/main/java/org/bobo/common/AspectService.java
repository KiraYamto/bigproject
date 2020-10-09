package org.bobo.common;

import brave.Tracer;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.bobo.controller.NsNstTemplateController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Aspect   //定义一个切面
@Configuration
public class AspectService {

    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");
    public static final Logger logger = LoggerFactory.getLogger(NsNstTemplateController.class);
    @Autowired
    Tracer tracer;
    @Pointcut("execution(* org.bobo.controller..*.*(..))")
    public void excudeService() {
    }
    @Before(value = "excudeService()")
    public void before(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        Object[] argsArr = joinPoint.getArgs();
        Object args = argsArr[0];
        logger.info("before MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));
        logstashLogger.info("before MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));
    }

    @After(value = "excudeService()")
    public void after(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        Object[] argsArr = joinPoint.getArgs();
        Object args = argsArr[0];
        logger.info("after MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));
        logstashLogger.info("after MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));
    }

    @AfterReturning(value = "excudeService()",returning = "result")
    public void result(JoinPoint joinPoint,Object result){
        String MethodName = joinPoint.getSignature().getName();
        Object[] argsArr = joinPoint.getArgs();
        Object args = argsArr[0];
        logger.info("AfterReturning MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args)+",result:" + result);
        logstashLogger.info("AfterReturning MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args)+",result:" + result);
    }

    @AfterThrowing(value = "excudeService()")
    public void exception(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        Object[] argsArr = joinPoint.getArgs();
        Object args = argsArr[0];
        logger.info("AfterThrowing MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));
        logstashLogger.info("AfterThrowing MethodName:"+MethodName+",argNames:"+ JSON.toJSONString(args));

    }
}
