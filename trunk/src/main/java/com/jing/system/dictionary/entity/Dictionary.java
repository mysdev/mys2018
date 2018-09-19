package com.jing.system.dictionary.entity;

import com.jing.utils.BaseEntity;

/**
 * 数据字典
 * @author lifeng
 *
 */
public class Dictionary extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 值
	 */
	private String value;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 是否生效(0=失效，1=有效)
	 */
	private Integer flag =1;
	
	/**
	 * 字典组编码
	 */
	private String groupCode;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dictionary [code=" + code + ", value=" + value + ", sort="
				+ sort + ", flag=" + flag + ", groupCode=" + groupCode + "]";
	}
	
	
}
