package com.jing.system.document.entity;

import java.util.Date;

import com.jing.utils.BaseEntity;

/**
 * 附件 实体类
 * 
 * @author codeing gen
 */
public class Document extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String did; // 主键:主键
	private String remark; // 文件描述:文件描述
	private String actual; // 文件名:文件名
	private String suffix; // 文件后缀:文件后缀
	private long size; // 文件大小:文件大小
	private Integer state; // 文件状态:文件状态
	private String url; // 文件存储路径:文件存储路径
	private String res; // 关联主键:关联主键

	private Date upTime;

	public String getDid() {
		return this.did;
	}

	public String getRemark() {
		return this.remark;
	}

	public String getActual() {
		return this.actual;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public long getSize() {
		return this.size;
	}

	public Integer getState() {
		return this.state;
	}

	public String getUrl() {
		return this.url;
	}

	public String getRes() {
		return this.res;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

}