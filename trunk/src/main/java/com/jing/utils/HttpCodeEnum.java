package com.jing.utils;

public enum HttpCodeEnum {

    HTTP_SUSESS( 200, "访问正常"), 
    HTTP_BAD_REQUEST(400, "请求参数异常"),
    HTTP_BAD_HEAD(400, "请求头参数异常"),
    HTTP_NO_PERMISSION(403, "没有权限"), 
    HTTP_NOT_FOUND(404, "找不到资源"), 
    HTTP_NOT_ALLOWED ( 405, "不支持当前请求方法"),
    HTTP_DATA_LOCK ( 406, "数据被锁定"),
    HTTP_SERVER_ERROR(500, "服务器异常");
	
	private Integer code;
	private String msg;
	
	private HttpCodeEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}

	/** 
	* @Title: getTypeByCode 
	* @Description: 根据错误代码查询类型
	* @param code
	* @return  HttpErrorEnum    返回类型 
	* @throws 
	*/
	public static HttpCodeEnum getTypeByCode(Integer code){
		for(HttpCodeEnum e: HttpCodeEnum.values()){
			if(code==e.getCode()){
				return e;
			}
		}
		return null;		
	}
	
	/** 
	* @Title: getMsgByCode 
	* @Description: 根据错误代码查询错误名称
	* @param code
	* @return  String    返回类型 
	* @throws 
	*/
	public static String getMsgByCode(Integer code){
		HttpCodeEnum e = getTypeByCode(code);
		if(e==null)
			return null;
		return e.getMsg();
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
