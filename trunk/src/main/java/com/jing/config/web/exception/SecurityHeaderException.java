package com.jing.config.web.exception;

import java.util.List;
import java.util.Map;

import com.jing.utils.JsonUtil;

public class SecurityHeaderException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public SecurityHeaderException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public SecurityHeaderException(String message) {
		this.message = message;
	}
	
	public SecurityHeaderException(Map<String,String> message) {
		this.message = JsonUtil.map2json(message);
	}
	
	public SecurityHeaderException(List<Map<String,String>> message) {
		this.message = JsonUtil.list2json(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
