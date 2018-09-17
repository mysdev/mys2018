package com.jing.core.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: MemberLevel
 * @Description: 会员体系实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class MemberLevel extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer levelId;	//tb_member_level:level_id  自标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String levelName;	//tb_member_level:level_name  级别名称  

	private Integer levelRfm;	//tb_member_level:level_rfm  成长值  

	private Integer parentId;	//tb_member_level:parent_id  上级会员级别  


	/**
	* @DatabasetableColumnName: tb_member_level:level_id
	* @Description: 获取属性        自标识
	* @return: Integer
	*/
	public Integer getLevelId(){
		return levelId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_level:level_id
	* @Description: 设置属性        自标识
	* @return: Integer
	*/
	public void setLevelId(Integer levelId){
		this.levelId = levelId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_level:level_name
	* @Description: 获取属性        级别名称
	* @return: String
	*/
	public String getLevelName(){
		return levelName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_level:level_name
	* @Description: 设置属性        级别名称
	* @return: String
	*/
	public void setLevelName(String levelName){
		this.levelName = levelName;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_level:level_rfm
	* @Description: 获取属性        成长值
	* @return: Integer
	*/
	public Integer getLevelRfm(){
		return levelRfm;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_level:level_rfm
	* @Description: 设置属性        成长值
	* @return: Integer
	*/
	public void setLevelRfm(Integer levelRfm){
		this.levelRfm = levelRfm;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_level:parent_id
	* @Description: 获取属性        上级会员级别
	* @return: Integer
	*/
	public Integer getParentId(){
		return parentId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_level:parent_id
	* @Description: 设置属性        上级会员级别
	* @return: Integer
	*/
	public void setParentId(Integer parentId){
		this.parentId = parentId;	
	}	
	
	
	
	
}

