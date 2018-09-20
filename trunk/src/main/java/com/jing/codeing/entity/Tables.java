package com.jing.codeing.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <br>
 * <b>功能：</b>表格<br>
 */
public class Tables implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tid;// 表id
	private String tableName;// 表名
	private String tableComment;// 注释
	private Boolean isCode =false;// 是否生成代码
	private String pakageURL;// 包路径
	private String className;// 类名

	private List<Columns> columns;// 列
	
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return this.tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public Boolean getIsCode() {
		return isCode;
	}

	public void setIsCode(Boolean isCode) {
		this.isCode = isCode;
	}

	public String getPakageURL() {
		return this.pakageURL;
	}

	public void setPakageURL(String pakageURL) {
		this.pakageURL = pakageURL;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
