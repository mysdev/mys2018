package com.jing.config.web.exception;

import java.util.List;
import java.util.Map;

import com.jing.utils.JsonUtil;

/**
 * @ClassName: AuthorityException
 * @Description: 用户权限不足
 * @author: Jinlong He
 * @date: 2017年5月11日 下午6:08:27
 */
public class AuthorityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public AuthorityException() {
		super();
	}
	/***
	 * 带message参数的构造函数
	 */
	public AuthorityException(String message) {
		super();
		this.message = message;
	}
	
	public AuthorityException(Map<String,String> message) {
		this.message = JsonUtil.map2json(message);
	}
	
	public AuthorityException(List<Map<String,String>> message) {
		this.message = JsonUtil.list2json(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
