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
 * @ClassName: TechnicianClass
 * @Description: 轮班详情实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class TechnicianClass extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer detailId;	//tc_technician_class:detail_id  自增标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer classId;	//tc_technician_class:class_id  归属轮班  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer technicianId;	//tc_technician_class:technician_id  技师标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer clockCt;	//tc_technician_class:clock_ct  轮钟次数  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer isWork;	//tc_technician_class:is_work  是否在班 0否 1在  

	private Integer technicianLevel;	//tc_technician_class:technician_level  轮班级别  

	private Integer priority;	//tc_technician_class:priority  挂起次数  

	private Integer seqencing;	//tc_technician_class:seqencing  轮班排序  


	/**
	* @DatabasetableColumnName: tc_technician_class:detail_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getDetailId(){
		return detailId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:detail_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setDetailId(Integer detailId){
		this.detailId = detailId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:class_id
	* @Description: 获取属性        归属轮班
	* @return: Integer
	*/
	public Integer getClassId(){
		return classId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:class_id
	* @Description: 设置属性        归属轮班
	* @return: Integer
	*/
	public void setClassId(Integer classId){
		this.classId = classId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:technician_id
	* @Description: 获取属性        技师标识
	* @return: Integer
	*/
	public Integer getTechnicianId(){
		return technicianId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:technician_id
	* @Description: 设置属性        技师标识
	* @return: Integer
	*/
	public void setTechnicianId(Integer technicianId){
		this.technicianId = technicianId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:clock_ct
	* @Description: 获取属性        轮钟次数
	* @return: Integer
	*/
	public Integer getClockCt(){
		return clockCt;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:clock_ct
	* @Description: 设置属性        轮钟次数
	* @return: Integer
	*/
	public void setClockCt(Integer clockCt){
		this.clockCt = clockCt;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:is_work
	* @Description: 获取属性        是否在班 0否 1在
	* @return: Integer
	*/
	public Integer getIsWork(){
		return isWork;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:is_work
	* @Description: 设置属性        是否在班 0否 1在
	* @return: Integer
	*/
	public void setIsWork(Integer isWork){
		this.isWork = isWork;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:technician_level
	* @Description: 获取属性        轮班级别
	* @return: Integer
	*/
	public Integer getTechnicianLevel(){
		return technicianLevel;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:technician_level
	* @Description: 设置属性        轮班级别
	* @return: Integer
	*/
	public void setTechnicianLevel(Integer technicianLevel){
		this.technicianLevel = technicianLevel;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:priority
	* @Description: 获取属性        挂起次数
	* @return: Integer
	*/
	public Integer getPriority(){
		return priority;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:priority
	* @Description: 设置属性        挂起次数
	* @return: Integer
	*/
	public void setPriority(Integer priority){
		this.priority = priority;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_class:seqencing
	* @Description: 获取属性        轮班排序
	* @return: Integer
	*/
	public Integer getSeqencing(){
		return seqencing;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_class:seqencing
	* @Description: 设置属性        轮班排序
	* @return: Integer
	*/
	public void setSeqencing(Integer seqencing){
		this.seqencing = seqencing;	
	}	
	
	
	
	
}

