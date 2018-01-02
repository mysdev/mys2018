package com.jing.config.web.exception;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jing.utils.JsonUtil;

public class ParameterException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public ParameterException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public ParameterException(String filed, String message) {
	    List<Map<String, String>> errors = Lists.newArrayList();
	    Map<String, String> error = Maps.newHashMap();
	    error.put("field", filed);
	    error.put("message", message);
	    errors.add(error);
		this.message = JsonUtil.list2json(errors);
	}
	
	public ParameterException(Integer index, String filed, String message) {
	    List<Map<String, String>> errors = Lists.newArrayList();
	    Map<String, String> error = Maps.newHashMap();
	    error.put("index", ""+index);
	    error.put("field", filed);
	    error.put("message", message);
	    errors.add(error);
		this.message = JsonUtil.list2json(errors);
	}
	
	public ParameterException(List<Map<String, String>> message) {
		this.message = JsonUtil.list2json(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
