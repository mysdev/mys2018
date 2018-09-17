package com.jing.system.logger.entity;

import java.util.Date;

import com.jing.utils.BaseEntity;

/**
 * 系统操作日志 实体类
 * 
 * @author codeing gen
 */
public class SysLog extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer logId; // 主键
	private Integer userId; // 用户ID
	private String userIp; // 用户IP
	private String oper; // 操作
	private String operClient; // 客户端
	private String operType; // 操作类型
	private Date operTime; // 操作时间
	private Integer operStatus; // 状态
	private String request; // 请求报文

	public Integer getLogId() {
		return this.logId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public String getOper() {
		return this.oper;
	}

	public String getOperClient() {
		return this.operClient;
	}

	public String getOperType() {
		return this.operType;
	}

	public Date getOperTime() {
		return this.operTime;
	}

	public Integer getOperStatus() {
		return this.operStatus;
	}

	public String getRequest() {
		return this.request;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public void setOperClient(String operClient) {
		this.operClient = operClient;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public void setOperStatus(Integer operStatus) {
		this.operStatus = operStatus;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}