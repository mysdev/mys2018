package com.jing.config.web.exception;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jing.utils.JsonUtil;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public NotFoundException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	public NotFoundException(String filed, String message) {
	    List<Map<String, String>> errors = Lists.newArrayList();
	    Map<String, String> error = Maps.newHashMap();
	    error.put("field", filed);
	    error.put("message", message);
	    errors.add(error);
		this.message = JsonUtil.list2json(errors);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
