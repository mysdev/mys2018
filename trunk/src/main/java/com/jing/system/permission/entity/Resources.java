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

	public Integer getResId() {	    return this.resId;	}
	public String getResName() {	    return this.resName;	}
	public String getResURL() {	    return this.resURL;	}
	public Integer getResType() {	    return this.resType;	}
	public String getResIcon() {	    return this.resIcon;	}
	public Integer getSort() {	    return this.sort;	}
	public Integer getPromission() {	    return this.promission;	}
	public Integer getParentId() {	    return this.parentId;	}
	public String getPageButtonKey() {	    return this.pageButtonKey;	}
	public String getCallback() {	    return this.callback;	}

	public void setResId(Integer resId){	this.resId = resId;	}
	public void setResName(String resName){	this.resName = resName;	}
	public void setResURL(String resURL){	this.resURL = resURL;	}
	public void setResType(Integer resType){	this.resType = resType;	}
	public void setResIcon(String icon){	this.resIcon = icon;	}
	public void setSort(Integer sort){	this.sort = sort;	}
	public void setPromission(Integer promission){	this.promission = promission;	}
	public void setParentId(Integer parentId){	this.parentId = parentId;	}
	public void setPageButtonKey(String pageButtonKey){	this.pageButtonKey = pageButtonKey;	}
	public void setCallback(String callback){	this.callback = callback;	}

}