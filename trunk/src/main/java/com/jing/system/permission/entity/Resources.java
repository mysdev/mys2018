package com.jing.system.permission.entity;

import com.jing.utils.BaseEntity;

/**
 * 系统资源（菜单、按钮） 实体类
 * @author codeing gen
 */
public class Resources extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer resId;   // 资源ID:资源ID
	private String resName;   // 资源名称:资源名称
	private String resURL;   // 资源URL:资源URL
	private Integer resType;   // 资源类型:资源类型[1=按钮，2=菜单]
	private String resIcon;   // 图标:图标
	private Integer sort;   // 序号:序号
	private Integer promission;   // 是否权限配置:是否权限配置
	private Integer parentId;   // 上级资源:上级资源
	private String pageButtonKey;   // 界面按钮标识:界面按钮标识
	private String callback;   // 回调函数:回调函数























}