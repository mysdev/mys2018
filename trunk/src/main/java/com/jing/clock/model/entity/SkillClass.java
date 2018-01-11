package com.jing.clock.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: SkillClass
 * @Description: 轮班实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class SkillClass extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer classId;	//tc_skill_class:class_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String className;	//tc_skill_class:class_name  轮班名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tc_skill_class:status  轮班状态  

	private Integer clockFlag;	//tc_skill_class:clock_flag  计钟指针  

	private Integer flag;	//tc_skill_class:flag  不计指针  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer types;	//tc_skill_class:types  排号规则 0按序1按次  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer isPriority;	//tc_skill_class:is_priority  挂起优先 0否1是  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer priorityAccumulate;	//tc_skill_class:priority_accumulate  挂起累计 0是1否  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer arriveWarn;	//tc_skill_class:arrive_warn  到时提醒 0否  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer arriveRemind;	//tc_skill_class:arrive_remind  提前播报 0否  


	/**
	* @DatabasetableColumnName: tc_skill_class:class_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getClassId(){
		return classId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:class_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setClassId(Integer classId){
		this.classId = classId;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:class_name
	* @Description: 获取属性        轮班名称
	* @return: String
	*/
	public String getClassName(){
		return className;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:class_name
	* @Description: 设置属性        轮班名称
	* @return: String
	*/
	public void setClassName(String className){
		this.className = className;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:status
	* @Description: 获取属性        轮班状态
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:status
	* @Description: 设置属性        轮班状态
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:clock_flag
	* @Description: 获取属性        计钟指针
	* @return: Integer
	*/
	public Integer getClockFlag(){
		return clockFlag;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:clock_flag
	* @Description: 设置属性        计钟指针
	* @return: Integer
	*/
	public void setClockFlag(Integer clockFlag){
		this.clockFlag = clockFlag;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:flag
	* @Description: 获取属性        不计指针
	* @return: Integer
	*/
	public Integer getFlag(){
		return flag;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:flag
	* @Description: 设置属性        不计指针
	* @return: Integer
	*/
	public void setFlag(Integer flag){
		this.flag = flag;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:types
	* @Description: 获取属性        排号规则 0按序1按次
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:types
	* @Description: 设置属性        排号规则 0按序1按次
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:is_priority
	* @Description: 获取属性        挂起优先 0否1是
	* @return: Integer
	*/
	public Integer getIsPriority(){
		return isPriority;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:is_priority
	* @Description: 设置属性        挂起优先 0否1是
	* @return: Integer
	*/
	public void setIsPriority(Integer isPriority){
		this.isPriority = isPriority;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:priority_accumulate
	* @Description: 获取属性        挂起累计 0是1否
	* @return: Integer
	*/
	public Integer getPriorityAccumulate(){
		return priorityAccumulate;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:priority_accumulate
	* @Description: 设置属性        挂起累计 0是1否
	* @return: Integer
	*/
	public void setPriorityAccumulate(Integer priorityAccumulate){
		this.priorityAccumulate = priorityAccumulate;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:arrive_warn
	* @Description: 获取属性        到时提醒 0否
	* @return: Integer
	*/
	public Integer getArriveWarn(){
		return arriveWarn;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:arrive_warn
	* @Description: 设置属性        到时提醒 0否
	* @return: Integer
	*/
	public void setArriveWarn(Integer arriveWarn){
		this.arriveWarn = arriveWarn;	
	}	
	/**
	* @DatabasetableColumnName: tc_skill_class:arrive_remind
	* @Description: 获取属性        提前播报 0否
	* @return: Integer
	*/
	public Integer getArriveRemind(){
		return arriveRemind;	
	}
	
	/**
	* @DatabasetableColumnName: tc_skill_class:arrive_remind
	* @Description: 设置属性        提前播报 0否
	* @return: Integer
	*/
	public void setArriveRemind(Integer arriveRemind){
		this.arriveRemind = arriveRemind;	
	}	
	
	
	
	
}

