package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Types
 * @Description: 类型配置实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Types extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer typeId;	//tb_types:type_id  类型标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer ass;	//tb_types:ass  归属分类 0房1手环  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String typeName;	//tb_types:type_name  类型名称  

	private java.math.BigDecimal lowConsumption;	//tb_types:low_consumption  最低消费  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_types:status  类型状态 0正常  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer isCircle;	//tb_types:is_circle  重复计费 0否1时长2时间点  

	private Integer circleStep;	//tb_types:circle_step  周期步长 时  

	private java.sql.Timestamp circleTime;	//tb_types:circle_time  计费时间点  


	/**
	* @DatabasetableColumnName: tb_types:type_id
	* @Description: 获取属性        类型标识
	* @return: Integer
	*/
	public Integer getTypeId(){
		return typeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:type_id
	* @Description: 设置属性        类型标识
	* @return: Integer
	*/
	public void setTypeId(Integer typeId){
		this.typeId = typeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:ass
	* @Description: 获取属性        归属分类 0房1手环
	* @return: Integer
	*/
	public Integer getAss(){
		return ass;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:ass
	* @Description: 设置属性        归属分类 0房1手环
	* @return: Integer
	*/
	public void setAss(Integer ass){
		this.ass = ass;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:type_name
	* @Description: 获取属性        类型名称
	* @return: String
	*/
	public String getTypeName(){
		return typeName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:type_name
	* @Description: 设置属性        类型名称
	* @return: String
	*/
	public void setTypeName(String typeName){
		this.typeName = typeName;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:low_consumption
	* @Description: 获取属性        最低消费
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getLowConsumption(){
		return lowConsumption;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:low_consumption
	* @Description: 设置属性        最低消费
	* @return: java.math.BigDecimal
	*/
	public void setLowConsumption(java.math.BigDecimal lowConsumption){
		this.lowConsumption = lowConsumption;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:status
	* @Description: 获取属性        类型状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:status
	* @Description: 设置属性        类型状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:is_circle
	* @Description: 获取属性        重复计费 0否1时长2时间点
	* @return: Integer
	*/
	public Integer getIsCircle(){
		return isCircle;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:is_circle
	* @Description: 设置属性        重复计费 0否1时长2时间点
	* @return: Integer
	*/
	public void setIsCircle(Integer isCircle){
		this.isCircle = isCircle;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:circle_step
	* @Description: 获取属性        周期步长 时
	* @return: Integer
	*/
	public Integer getCircleStep(){
		return circleStep;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:circle_step
	* @Description: 设置属性        周期步长 时
	* @return: Integer
	*/
	public void setCircleStep(Integer circleStep){
		this.circleStep = circleStep;	
	}	
	/**
	* @DatabasetableColumnName: tb_types:circle_time
	* @Description: 获取属性        计费时间点
	* @return: java.sql.Timestamp
	*/
	public java.sql.Timestamp getCircleTime(){
		return circleTime;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types:circle_time
	* @Description: 设置属性        计费时间点
	* @return: java.sql.Timestamp
	*/
	public void setCircleTime(java.sql.Timestamp circleTime){
		this.circleTime = circleTime;	
	}	
	
	
	
	
}

