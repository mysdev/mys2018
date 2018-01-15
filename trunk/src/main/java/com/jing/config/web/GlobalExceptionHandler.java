package com.jing.config.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.fastjson.JSONException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.ForeignKeyException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.config.web.exception.UniqueException;
import com.jing.utils.HttpCodeEnum;
import com.jing.utils.JsonUtil;

/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理类
 * @author: li chao
 * @date: 2017年4月6日 上午9:51:34
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    /**
     * 没有权限 异常
     * <p/>
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> processUnauthenticatedException(UnauthorizedException e,HttpServletResponse response) {
    	logger.error("没有访问权限", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_NO_PERMISSION.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_NO_PERMISSION.getCode());
		returnMap.put("message","没有访问权限");
		returnMap.put("errors", e.getMessage());
		return returnMap;
    }
    
    
	/**
	 * 
	 * @Title: notFoundException
	 * @Description: 资源不存在异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(NotFoundException.class)
	public Map<String, Object> notFoundException(NotFoundException e, HttpServletResponse response) {
	    logger.error("资源不存在", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_NOT_FOUND.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_NOT_FOUND.getCode());
		returnMap.put("message","资源不存在");
		returnMap.put("errors", e.getMessage());
		return returnMap;
	}

	/**
	 * 
	 * @Title: JSONException
	 * @Description: json异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(JSONException.class)
	public Map<String, Object> jSONException(JSONException e, HttpServletResponse response) {
	    logger.error("不符合json格式", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
		returnMap.put("message", "参数异常");
		Object list = null;
		try {
			list = JsonUtil.json2object(e.getMessage(), Map.class);
			returnMap.put("errors", list);
		} catch (Exception e2) {
			returnMap.put("errors", Lists.newArrayList());
		}
		return returnMap;
	}
	
	
	/**
	 * 
	 * @Title: parameterException
	 * @Description: 参数异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(ParameterException.class)
	public Map<String, Object> parameterException(ParameterException e, HttpServletResponse response) {
	    logger.error("参数异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
		returnMap.put("message", "参数异常");

		Object list = null;
		try {			
			list = JsonUtil.json2object(e.getMessage(), List.class);
			returnMap.put("errors", list);
		} catch (Exception e2) {
			returnMap.put("errors", JsonUtil.json2object(e.getMessage()));
		}
		return returnMap;
	}	
	
	/**
	 * 
	 * @Title: ForeignKeyException
	 * @Description: 唯一约束异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(ForeignKeyException.class)
	public Map<String, Object> foreignKeyException(ForeignKeyException e, HttpServletResponse response,HttpServletRequest request) {
	    logger.error("外键约束异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("message", HttpCodeEnum.HTTP_SERVER_ERROR.getMsg());
		Object list = JsonUtil.json2object(e.getMessage(), Map.class);
		returnMap.put("errors", list);
		return returnMap;
	}
	
	/**
	 * 
	 * @Title: UniqueException
	 * @Description: 唯一约束异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(UniqueException.class)
	public Map<String, Object> uniqueException(UniqueException e, HttpServletResponse response,HttpServletRequest request) {
	    logger.error("唯一约束异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("message", HttpCodeEnum.HTTP_SERVER_ERROR.getMsg());
		Object list = JsonUtil.json2object(e.getMessage(), Map.class);
		returnMap.put("errors", list);
		return returnMap;
	}
	
	/**
	 * 
	 * @Title: DuplicateKeyException
	 * @Description: 唯一约束异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(DuplicateKeyException.class)
	public Map<String, Object> duplicateKeyException(DuplicateKeyException e, HttpServletResponse response,HttpServletRequest request) {
	    logger.error("唯一约束异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("message", HttpCodeEnum.HTTP_SERVER_ERROR.getMsg());
		returnMap.put("errors", Lists.newArrayList());
		return returnMap;
	}
	
	/**
	 * 
	 * @Title: DataIntegrityViolationException
	 * @Description: 完整性约束异常处理
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: li chao
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public Map<String, Object> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletResponse response,HttpServletRequest request) {
	    logger.error("完整性约束异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("code", HttpCodeEnum.HTTP_SERVER_ERROR.getCode());
		returnMap.put("message", HttpCodeEnum.HTTP_SERVER_ERROR.getMsg());
		returnMap.put("errors", Lists.newArrayList());
		return returnMap;
	}

	
	/**
     * 
     * @Title: httpMessageNotReadableExceptionException
     * @Description: 参数转换异常处理
     * @param e
     * @param response
     * @return Map<String,Object>
     * @author: 
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Object> httpMessageNotReadableExceptionException(HttpMessageNotReadableException e, HttpServletResponse response) {
        logger.error("参数转换异常", e);
        Map<String, Object> returnMap = Maps.newHashMap();
        response.setStatus(HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
        returnMap.put("code", HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
        returnMap.put("message", HttpCodeEnum.HTTP_BAD_REQUEST.getMsg());
        returnMap.put("errors", Lists.newArrayList());
        return returnMap;
    }
    
    /**
     * 
     * @Title: IllegalArgumentException
     * @Description: 参数转换异常
     * @param e
     * @param response
     * @return Map<String,Object>
     * @author: 
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> illegalArgumentException(IllegalArgumentException e, HttpServletResponse response) {
        logger.error("请求参数异常", e);
        Map<String, Object> returnMap = Maps.newHashMap();
        response.setStatus(HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
        returnMap.put("code", HttpCodeEnum.HTTP_BAD_REQUEST.getCode());
        returnMap.put("message", HttpCodeEnum.HTTP_BAD_REQUEST.getMsg());
        returnMap.put("errors", Lists.newArrayList());
        return returnMap;
    }
    
    /**
     * 
    * @Title: httpRequestMethodNotSupportedException 
    * @Description: 不支持当前请求方法 
    * @param e
    * @param response
    * @return Map<String,Object>
    * @author: li chao
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletResponse response) {
      logger.error("不支持当前请求方法", e);
      Map<String, Object> returnMap = Maps.newHashMap();
      response.setStatus(HttpCodeEnum.HTTP_NOT_ALLOWED.getCode());
      returnMap.put("code", HttpCodeEnum.HTTP_NOT_ALLOWED.getCode());
      returnMap.put("message", HttpCodeEnum.HTTP_NOT_ALLOWED.getMsg());
      returnMap.put("errors", Lists.newArrayList());
      return returnMap;
    }
    
    /**
	 * 
	 * @Title: CustomException
	 * @Description: 自定义异常
	 * @param e
	 * @param response
	 * @return Map<String,Object>
	 * @author: Jinlong He
	 */
	@ExceptionHandler(CustomException.class)
	public Map<String, Object> CustomException(CustomException e, HttpServletResponse response,HttpServletRequest request) {
	    logger.error("自定义异常", e);
		Map<String, Object> returnMap = Maps.newHashMap();
		response.setStatus(e.getCode());
		returnMap.put("code", e.getCode());
		returnMap.put("message", e.getMessage());
		returnMap.put("errors", e.getErrors());
		return returnMap;
	}
    
}
