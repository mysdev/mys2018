package com.jing.system.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Log
 * @Description: 日志实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Log extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer logId;	//ts_log:log_id  日志标识  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String userId;	//ts_log:user_id  用户名  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String userIp;	//ts_log:user_ip  访问IP  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String oper;	//ts_log:oper  操作名称  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String operUa;	//ts_log:oper_ua  来源UA  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String operType;	//ts_log:oper_type  来源类型  

	private Integer operStatus;	//ts_log:oper_status  来源状态  

	@Length(min=0, max=65535, message="{org.hibernate.validator.constraints.Length.message}")
	private String request;	//ts_log:request  请求全文  


	/**
	* @DatabasetableColumnName: ts_log:log_id
	* @Description: 获取属性        日志标识
	* @return: Integer
	*/
	public Integer getLogId(){
		return logId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:log_id
	* @Description: 设置属性        日志标识
	* @return: Integer
	*/
	public void setLogId(Integer logId){
		this.logId = logId;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:user_id
	* @Description: 获取属性        用户名
	* @return: String
	*/
	public String getUserId(){
		return userId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:user_id
	* @Description: 设置属性        用户名
	* @return: String
	*/
	public void setUserId(String userId){
		this.userId = userId;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:user_ip
	* @Description: 获取属性        访问IP
	* @return: String
	*/
	public String getUserIp(){
		return userIp;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:user_ip
	* @Description: 设置属性        访问IP
	* @return: String
	*/
	public void setUserIp(String userIp){
		this.userIp = userIp;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:oper
	* @Description: 获取属性        操作名称
	* @return: String
	*/
	public String getOper(){
		return oper;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:oper
	* @Description: 设置属性        操作名称
	* @return: String
	*/
	public void setOper(String oper){
		this.oper = oper;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:oper_ua
	* @Description: 获取属性        来源UA
	* @return: String
	*/
	public String getOperUa(){
		return operUa;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:oper_ua
	* @Description: 设置属性        来源UA
	* @return: String
	*/
	public void setOperUa(String operUa){
		this.operUa = operUa;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:oper_type
	* @Description: 获取属性        来源类型
	* @return: String
	*/
	public String getOperType(){
		return operType;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:oper_type
	* @Description: 设置属性        来源类型
	* @return: String
	*/
	public void setOperType(String operType){
		this.operType = operType;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:oper_status
	* @Description: 获取属性        来源状态
	* @return: Integer
	*/
	public Integer getOperStatus(){
		return operStatus;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:oper_status
	* @Description: 设置属性        来源状态
	* @return: Integer
	*/
	public void setOperStatus(Integer operStatus){
		this.operStatus = operStatus;	
	}	
	/**
	* @DatabasetableColumnName: ts_log:request
	* @Description: 获取属性        请求全文
	* @return: String
	*/
	public String getRequest(){
		return request;	
	}
	
	/**
	* @DatabasetableColumnName: ts_log:request
	* @Description: 设置属性        请求全文
	* @return: String
	*/
	public void setRequest(String request){
		this.request = request;	
	}	
	
	
	
	
}

