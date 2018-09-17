package com.jing.system.sysconfig.entity;

import com.jing.utils.BaseEntity;

/**
 * 系统参数 实体类
 * 
 * @author codeing gen
 */
public class SysConfig extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer pid; // 主键
	private String pcode; // 编码
	private String pvalue; // 值
	private String desc; // 描述

	public Integer getPid() {
		return this.pid;
	}

	public String getPcode() {
		return this.pcode;
	}

	public String getPvalue() {
		return this.pvalue;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}