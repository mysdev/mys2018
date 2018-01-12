package com.jing.config.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.collect.Maps;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @ClassName: AppErrorController
 * @Description: 全局异常类
 * @author: li chao
 * @date: 2017年4月6日 下午3:01:19
 */
@RestController
@ApiIgnore
public class GlobalErrorController implements ErrorController {


    private static GlobalErrorController globalErrorController;

    @Autowired
    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    public GlobalErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    public GlobalErrorController() {
        if(globalErrorController == null){
        	globalErrorController = new GlobalErrorController(errorAttributes);
        }
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Map<String, Object> error(HttpServletRequest request,HttpServletResponse response) {
          Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
          String path=(String)body.get("path");
          //HttpStatus status = getStatus(request);
          //return new ResponseEntity<Map<String, Object>>(body, status);
    	Map<String, Object> map =  Maps.newHashMap();
    	if(400 == response.getStatus()){
    		map.put("code", "400");
    		map.put("message", "请求参数异常");
    		map.put("errors", Maps.newHashMap());
    	}else if(500 == response.getStatus()){
    		map.put("code", "500");
    		map.put("message", "服务器异常");
    		map.put("errors", Maps.newHashMap());
    	}else if(404 == response.getStatus()){
    		map.put("code", "404");
    		map.put("message", "资源"+path+"不存在");
    		map.put("errors", Maps.newHashMap());
    	}else if(405 == response.getStatus()){
    		map.put("code", "405");
    		map.put("message", "不支持当前请求方法");
    		map.put("errors", Maps.newHashMap());
    	}
    	return map;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    @SuppressWarnings("unused")
	private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {     
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);  
        Map<String, Object> map = errorAttributes.getErrorAttributes(requestAttributes,includeStackTrace);
        String URL = request.getRequestURL().toString();
        map.put("URL", URL);        
        return map;
    }

    @SuppressWarnings("unused")
	private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    } 

}
