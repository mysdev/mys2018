package com.jing.config.web.exception;

import java.util.List;
import java.util.Map;

import com.jing.utils.JsonUtil;

public class UniqueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;

	public UniqueException() {
		super();
	}
	
	public UniqueException(Map<String,String> message) {
		this.message = JsonUtil.map2json(message);
	}
	
	public UniqueException(List<Map<String,String>> message) {
		this.message = JsonUtil.list2json(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
