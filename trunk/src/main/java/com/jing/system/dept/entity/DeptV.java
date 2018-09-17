package com.jing.system.dept.entity;

/**
 * 有部门层级 实体类
 * @author 
 */
public class DeptV extends Dept{
	private static final long serialVersionUID = 1L;


	private Integer level;   // 状态


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


}