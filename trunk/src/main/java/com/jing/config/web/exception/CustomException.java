package com.jing.config.web.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CustomException
 * @Description: 自定义异常
 * @author: Jinlong He
 * @date: 2017年9月1日 上午8:34:17
 */
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * @Fields message : 异常信息 
	 */
	private String message;
	
	private Integer code;
	
	private List<Map<String, String>> errors;	
	
//	public CustomException(Integer code, String message, Object obj){
//		super();
//		this.code = code;
//		this.message = message;
//		if(obj instanceof List){
//			errors.addAll((List<?>)obj);
//		}
//		errors = new ArrayList<Object>();
//		if(obj instanceof String){
//			errors.add((String)obj);
//		}else if(obj instanceof Map){
//			errors.add((Map<?, ?>)obj);
//		}else if(obj instanceof Set){
//			errors.addAll((Set<?>)obj);
//		}else{
//			errors.add(obj);
//		}	
//	}
	
	public CustomException(Integer code, String message, String... obj){
		super();
		this.code = code;
		this.message = message;
		this.errors = new ArrayList<Map<String, String>>();  
		if(obj!=null && obj.length>0){
			for(int i=0; i<obj.length; i++){
				Map<String, String> item = new HashMap<String, String>();
				item.put("field", obj[i]);
				if(i+1<obj.length){					
					item.put("message", obj[++i]);
				}
				errors.add(item);
			}
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Map<String, String>> getErrors() {
		return errors;
	}

	public void setErrors(List<Map<String, String>> errors) {
		this.errors = errors;
	}
	
	
	
	
	
	
	
	
}
