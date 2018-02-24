package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: ClockSkill
 * @Description: 技能实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时22分
 */
public class ClockSkill extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer skillId;	//tc_clock_skill:skill_id  技能标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tc_clock_skill:store_id  归属门店  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String skillName;	//tc_clock_skill:skill_name  技能名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer materialId;	//tc_clock_skill:material_id  服务标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer isClock;	//tc_clock_skill:is_clock  是否计钟 0是  

	private Integer classs;	//tc_clock_skill:classs  归属轮班  

	//@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tc_clock_skill:status  技能状态 0正常  


	/**
	* @DatabasetableColumnName: tc_clock_skill:skill_id
	* @Description: 获取属性        技能标识
	* @return: Integer
	*/
	public Integer getSkillId(){
		return skillId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:skill_id
	* @Description: 设置属性        技能标识
	* @return: Integer
	*/
	public void setSkillId(Integer skillId){
		this.skillId = skillId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:skill_name
	* @Description: 获取属性        技能名称
	* @return: String
	*/
	public String getSkillName(){
		return skillName;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:skill_name
	* @Description: 设置属性        技能名称
	* @return: String
	*/
	public void setSkillName(String skillName){
		this.skillName = skillName;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:material_id
	* @Description: 获取属性        服务标识
	* @return: Integer
	*/
	public Integer getMaterialId(){
		return materialId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:material_id
	* @Description: 设置属性        服务标识
	* @return: Integer
	*/
	public void setMaterialId(Integer materialId){
		this.materialId = materialId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:is_clock
	* @Description: 获取属性        是否计钟 0是
	* @return: Integer
	*/
	public Integer getIsClock(){
		return isClock;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:is_clock
	* @Description: 设置属性        是否计钟 0是
	* @return: Integer
	*/
	public void setIsClock(Integer isClock){
		this.isClock = isClock;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:classs
	* @Description: 获取属性        归属轮班
	* @return: Integer
	*/
	public Integer getClasss(){
		return classs;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:classs
	* @Description: 设置属性        归属轮班
	* @return: Integer
	*/
	public void setClasss(Integer classs){
		this.classs = classs;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_skill:status
	* @Description: 获取属性        技能状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_skill:status
	* @Description: 设置属性        技能状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

