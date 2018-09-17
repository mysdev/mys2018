package com.jing.system.dept.entity;

import com.jing.utils.BaseEntity;

/**
 * 部门 实体类
 * 
 * @author codeing gen
 */
public class Dept extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer deptCode; // 部门编码
	private String deptName; // 部门名称
	private String remark; // 部门简介
	private Integer pid; // 上级部门
	private Integer sort; // 排序
	private Integer status = 1; // 状态
	private String files; // 附件

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Integer getDeptCode() {
		return this.deptCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public String getRemark() {
		return this.remark;
	}

	public Integer getPid() {
		return this.pid;
	}

	public Integer getSort() {
		return this.sort;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}