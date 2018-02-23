package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: TechnicianSkill
 * @Description: 技师技能实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class TechnicianSkill extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer tsId;	//tc_technician_skill:ts_id  自增标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer skillId;	//tc_technician_skill:skill_id  技能标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer technicianId;	//tc_technician_skill:technician_id  技师标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=9, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer skillLevel;	//tc_technician_skill:skill_level  技能等级  


	/**
	* @DatabasetableColumnName: tc_technician_skill:ts_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getTsId(){
		return tsId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_skill:ts_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setTsId(Integer tsId){
		this.tsId = tsId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_skill:skill_id
	* @Description: 获取属性        技能标识
	* @return: Integer
	*/
	public Integer getSkillId(){
		return skillId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_skill:skill_id
	* @Description: 设置属性        技能标识
	* @return: Integer
	*/
	public void setSkillId(Integer skillId){
		this.skillId = skillId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_skill:technician_id
	* @Description: 获取属性        技师标识
	* @return: Integer
	*/
	public Integer getTechnicianId(){
		return technicianId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_skill:technician_id
	* @Description: 设置属性        技师标识
	* @return: Integer
	*/
	public void setTechnicianId(Integer technicianId){
		this.technicianId = technicianId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_skill:skill_level
	* @Description: 获取属性        技能等级
	* @return: Integer
	*/
	public Integer getSkillLevel(){
		return skillLevel;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_skill:skill_level
	* @Description: 设置属性        技能等级
	* @return: Integer
	*/
	public void setSkillLevel(Integer skillLevel){
		this.skillLevel = skillLevel;	
	}	
	
	
	
	
}

