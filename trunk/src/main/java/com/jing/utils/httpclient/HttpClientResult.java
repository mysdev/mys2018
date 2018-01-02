package com.jing.utils.httpclient;

import java.io.Serializable;

/**
 * @ClassName: HttpClientResult
 * @Description: HTTP请求简单返回
 * @author: Jinlong He
 * @date: 2017年6月23日 上午10:23:01
 */
public class HttpClientResult implements Serializable{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String body;
	
	public HttpClientResult(){
		
	}
	public HttpClientResult(String body){
		setCode(200);
		this.setBody(body);
	}
	public HttpClientResult(Integer code, String body){
		this.setCode(code);
		this.setBody(body);
	}	
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
    public String toString() {
        return "{\"code\":" + code +",\"body\":\"" + body + "\"}";
    }

}
