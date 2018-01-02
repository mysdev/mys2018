package com.jing.config.web.filter;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;



@Aspect   //定义一个切面
@Configuration
public class LogRecordAspect {
private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.jing.*.controller.*Controller.*(..))")
    public void excudeService() {
    }

    @Around("execution(* com.jing.*.controller.*Controller.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String str, wholeStr = "";
//        if(request.getContentLength()>0){
//        	 BufferedReader br = request.getReader();
//    	     while((str = br.readLine()) != null){
//    	     wholeStr += str;
//    	     }
//        }
		
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}, body:{}", url, method, uri, queryString,wholeStr);
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        //JSONObject json = new JSONObject();
        logger.info("请求结束，controller的返回值是 " + JSONObject.toJSONString(result));
        return result;
    }
}
