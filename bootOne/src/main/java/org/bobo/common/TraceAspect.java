package org.bobo.common;

import brave.Tracer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect   //定义一个切面
@Configuration
public class TraceAspect {

    private static final Logger logger = LoggerFactory.getLogger(TraceAspect.class);
    @Autowired
    Tracer tracer;
    @Pointcut("execution(* org.bobo.controller..*.*(..))")
    public void excudeService() {
    }
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {},--span :{}", url, method, uri, queryString,tracer.currentSpan().toString());
        // result的值就是被拦截方法的返回值
        logger.info("test");
        Object result = pjp.proceed();
        logger.info("请求结束，controller的返回值是 {} - span:{}", tracer.currentSpan().toString(), JSON.toJSONString(result));

        return result;
    }
}
