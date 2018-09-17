package com.jing.clock.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: ClockRecord
 * @Description: 应钟记录实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class ClockRecord extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer recordId;	//tc_clock_record:record_id  应钟标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer orderId;	//tc_clock_record:order_id  订单标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer technicianId;	//tc_clock_record:technician_id  技师标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer classId;	//tc_clock_record:class_id  归属轮班  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tc_clock_record:status  应钟状态 正常0 过时1  

	private Date beginTime;	//tc_clock_record:begin_time  上钟时间  

	private Date endTime;	//tc_clock_record:end_time  预计下钟时间  

	private Date actureTime;	//tc_clock_record:acture_time  实际下钟时间  

	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer recordStatus;	//tc_clock_record:record_status  服务状态 0完成 1退换  


	/**
	* @DatabasetableColumnName: tc_clock_record:record_id
	* @Description: 获取属性        应钟标识
	* @return: Integer
	*/
	public Integer getRecordId(){
		return recordId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:record_id
	* @Description: 设置属性        应钟标识
	* @return: Integer
	*/
	public void setRecordId(Integer recordId){
		this.recordId = recordId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:order_id
	* @Description: 获取属性        订单标识
	* @return: Integer
	*/
	public Integer getOrderId(){
		return orderId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:order_id
	* @Description: 设置属性        订单标识
	* @return: Integer
	*/
	public void setOrderId(Integer orderId){
		this.orderId = orderId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:technician_id
	* @Description: 获取属性        技师标识
	* @return: Integer
	*/
	public Integer getTechnicianId(){
		return technicianId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:technician_id
	* @Description: 设置属性        技师标识
	* @return: Integer
	*/
	public void setTechnicianId(Integer technicianId){
		this.technicianId = technicianId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:class_id
	* @Description: 获取属性        归属轮班
	* @return: Integer
	*/
	public Integer getClassId(){
		return classId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:class_id
	* @Description: 设置属性        归属轮班
	* @return: Integer
	*/
	public void setClassId(Integer classId){
		this.classId = classId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:status
	* @Description: 获取属性        应钟状态 正常0 过时1
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:status
	* @Description: 设置属性        应钟状态 正常0 过时1
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:begin_time
	* @Description: 获取属性        上钟时间
	* @return: Date
	*/
	public Date getBeginTime(){
		return beginTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:begin_time
	* @Description: 设置属性        上钟时间
	* @return: Date
	*/
	public void setBeginTime(Date beginTime){
		this.beginTime = beginTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:end_time
	* @Description: 获取属性        预计下钟时间
	* @return: Date
	*/
	public Date getEndTime(){
		return endTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:end_time
	* @Description: 设置属性        预计下钟时间
	* @return: Date
	*/
	public void setEndTime(Date endTime){
		this.endTime = endTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:acture_time
	* @Description: 获取属性        实际下钟时间
	* @return: Date
	*/
	public Date getActureTime(){
		return actureTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:acture_time
	* @Description: 设置属性        实际下钟时间
	* @return: Date
	*/
	public void setActureTime(Date actureTime){
		this.actureTime = actureTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_record:record_status
	* @Description: 获取属性        服务状态 0完成 1退换
	* @return: Integer
	*/
	public Integer getRecordStatus(){
		return recordStatus;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_record:record_status
	* @Description: 设置属性        服务状态 0完成 1退换
	* @return: Integer
	*/
	public void setRecordStatus(Integer recordStatus){
		this.recordStatus = recordStatus;	
	}	
	
	
	
	
}

