package com.jing.system.permission.entity;

/**
 * 系统资源（菜单、按钮） 实体类
 * 
 * @author codeing gen
 */
public class VResources extends Resources {
	private static final long serialVersionUID = 1L;
	private String checked; // 资源名称:资源名称

	public String getChecked() {
		return this.checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}