package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Technician
 * @Description: 技师实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class Technician extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer technicianId;	//tc_technician:technician_id  技师标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tc_technician:store_id  归属门店  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tc_technician:emp_id  员工标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String techNo;	//tc_technician:tech_no  技师代号  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String techCard;	//tc_technician:tech_card  技师卡号  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String techName;	//tc_technician:tech_name  技师呢称  

	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer sex;	//tc_technician:sex  性别 0女  

	private Integer shiftId;	//tc_technician:shift_id  技师班次  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tc_technician:status  技师状态 0正常  

	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer shiftStatus;	//tc_technician:shift_status  工作状态 0盖牌 1翻牌 2上钟 3接单  


	/**
	* @DatabasetableColumnName: tc_technician:technician_id
	* @Description: 获取属性        技师标识
	* @return: Integer
	*/
	public Integer getTechnicianId(){
		return technicianId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:technician_id
	* @Description: 设置属性        技师标识
	* @return: Integer
	*/
	public void setTechnicianId(Integer technicianId){
		this.technicianId = technicianId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:tech_no
	* @Description: 获取属性        技师代号
	* @return: String
	*/
	public String getTechNo(){
		return techNo;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:tech_no
	* @Description: 设置属性        技师代号
	* @return: String
	*/
	public void setTechNo(String techNo){
		this.techNo = techNo;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:tech_card
	* @Description: 获取属性        技师卡号
	* @return: String
	*/
	public String getTechCard(){
		return techCard;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:tech_card
	* @Description: 设置属性        技师卡号
	* @return: String
	*/
	public void setTechCard(String techCard){
		this.techCard = techCard;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:tech_name
	* @Description: 获取属性        技师呢称
	* @return: String
	*/
	public String getTechName(){
		return techName;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:tech_name
	* @Description: 设置属性        技师呢称
	* @return: String
	*/
	public void setTechName(String techName){
		this.techName = techName;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:sex
	* @Description: 获取属性        性别 0女
	* @return: Integer
	*/
	public Integer getSex(){
		return sex;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:sex
	* @Description: 设置属性        性别 0女
	* @return: Integer
	*/
	public void setSex(Integer sex){
		this.sex = sex;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:shift_id
	* @Description: 获取属性        技师班次
	* @return: Integer
	*/
	public Integer getShiftId(){
		return shiftId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:shift_id
	* @Description: 设置属性        技师班次
	* @return: Integer
	*/
	public void setShiftId(Integer shiftId){
		this.shiftId = shiftId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:status
	* @Description: 获取属性        技师状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:status
	* @Description: 设置属性        技师状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician:shift_status
	* @Description: 获取属性        工作状态 0盖牌 1翻牌 2上钟 3接单
	* @return: Integer
	*/
	public Integer getShiftStatus(){
		return shiftStatus;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician:shift_status
	* @Description: 设置属性        工作状态 0盖牌 1翻牌 2上钟 3接单
	* @return: Integer
	*/
	public void setShiftStatus(Integer shiftStatus){
		this.shiftStatus = shiftStatus;	
	}	
	
	
	
	
}

