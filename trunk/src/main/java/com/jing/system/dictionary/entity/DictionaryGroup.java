package com.jing.system.dictionary.entity;

import java.util.List;

import com.jing.utils.BaseEntity;

/**
 * 数据字典组编码
 * @author lifeng
 *
 */
public class DictionaryGroup extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/**
	 * 字典组编码
	 */
	private String code;
	
	/**
	 * 字典组描述
	 */
	private String desc;
	
	/**
	 * 字典值
	 */
	List<Dictionary> dictionarys;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Dictionary> getDictionarys() {
		return dictionarys;
	}

	public void setDictionarys(List<Dictionary> dictionarys) {
		this.dictionarys = dictionarys;
	}
	
	
}
