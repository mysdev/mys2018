package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: TechnicianShift
 * @Description: 技师班次实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class TechnicianShift extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer shiftId;	//tc_technician_shift:shift_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tc_technician_shift:store_id  归属门店  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String shiftName;	//tc_technician_shift:shift_name  班次名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.sql.Timestamp inTime;	//tc_technician_shift:in_time  起班时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.sql.Timestamp outTime;	//tc_technician_shift:out_time  交班时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tc_technician_shift:status  状态 0正常  


	/**
	* @DatabasetableColumnName: tc_technician_shift:shift_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getShiftId(){
		return shiftId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:shift_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setShiftId(Integer shiftId){
		this.shiftId = shiftId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_shift:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_shift:shift_name
	* @Description: 获取属性        班次名称
	* @return: String
	*/
	public String getShiftName(){
		return shiftName;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:shift_name
	* @Description: 设置属性        班次名称
	* @return: String
	*/
	public void setShiftName(String shiftName){
		this.shiftName = shiftName;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_shift:in_time
	* @Description: 获取属性        起班时间
	* @return: java.sql.Timestamp
	*/
	public java.sql.Timestamp getInTime(){
		return inTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:in_time
	* @Description: 设置属性        起班时间
	* @return: java.sql.Timestamp
	*/
	public void setInTime(java.sql.Timestamp inTime){
		this.inTime = inTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_shift:out_time
	* @Description: 获取属性        交班时间
	* @return: java.sql.Timestamp
	*/
	public java.sql.Timestamp getOutTime(){
		return outTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:out_time
	* @Description: 设置属性        交班时间
	* @return: java.sql.Timestamp
	*/
	public void setOutTime(java.sql.Timestamp outTime){
		this.outTime = outTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_technician_shift:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_technician_shift:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

