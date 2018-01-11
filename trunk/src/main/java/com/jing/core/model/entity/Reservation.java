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
 * @ClassName: Reservation
 * @Description: 房间预定实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Reservation extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer reservationId;	//tb_reservation:reservation_id  预定标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String roomId;	//tb_reservation:room_id  房间标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date startTime;	//tb_reservation:start_time  开始时间  

	private Date endTime;	//tb_reservation:end_time  结束时间  

	private Date estimateTime;	//tb_reservation:estimate_time  预计到达时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date reserveTime;	//tb_reservation:reserve_time  保留时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberId;	//tb_reservation:member_id  会员标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String estimatePerson;	//tb_reservation:estimate_person  预定人员  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.lang.Object estimateCall;	//tb_reservation:estimate_call  联系电话  


	/**
	* @DatabasetableColumnName: tb_reservation:reservation_id
	* @Description: 获取属性        预定标识
	* @return: Integer
	*/
	public Integer getReservationId(){
		return reservationId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:reservation_id
	* @Description: 设置属性        预定标识
	* @return: Integer
	*/
	public void setReservationId(Integer reservationId){
		this.reservationId = reservationId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:room_id
	* @Description: 获取属性        房间标识
	* @return: String
	*/
	public String getRoomId(){
		return roomId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:room_id
	* @Description: 设置属性        房间标识
	* @return: String
	*/
	public void setRoomId(String roomId){
		this.roomId = roomId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:start_time
	* @Description: 获取属性        开始时间
	* @return: Date
	*/
	public Date getStartTime(){
		return startTime;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:start_time
	* @Description: 设置属性        开始时间
	* @return: Date
	*/
	public void setStartTime(Date startTime){
		this.startTime = startTime;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:end_time
	* @Description: 获取属性        结束时间
	* @return: Date
	*/
	public Date getEndTime(){
		return endTime;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:end_time
	* @Description: 设置属性        结束时间
	* @return: Date
	*/
	public void setEndTime(Date endTime){
		this.endTime = endTime;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_time
	* @Description: 获取属性        预计到达时间
	* @return: Date
	*/
	public Date getEstimateTime(){
		return estimateTime;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_time
	* @Description: 设置属性        预计到达时间
	* @return: Date
	*/
	public void setEstimateTime(Date estimateTime){
		this.estimateTime = estimateTime;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:reserve_time
	* @Description: 获取属性        保留时间
	* @return: Date
	*/
	public Date getReserveTime(){
		return reserveTime;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:reserve_time
	* @Description: 设置属性        保留时间
	* @return: Date
	*/
	public void setReserveTime(Date reserveTime){
		this.reserveTime = reserveTime;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:member_id
	* @Description: 获取属性        会员标识
	* @return: String
	*/
	public String getMemberId(){
		return memberId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:member_id
	* @Description: 设置属性        会员标识
	* @return: String
	*/
	public void setMemberId(String memberId){
		this.memberId = memberId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_person
	* @Description: 获取属性        预定人员
	* @return: String
	*/
	public String getEstimatePerson(){
		return estimatePerson;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_person
	* @Description: 设置属性        预定人员
	* @return: String
	*/
	public void setEstimatePerson(String estimatePerson){
		this.estimatePerson = estimatePerson;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_call
	* @Description: 获取属性        联系电话
	* @return: java.lang.Object
	*/
	public java.lang.Object getEstimateCall(){
		return estimateCall;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation:estimate_call
	* @Description: 设置属性        联系电话
	* @return: java.lang.Object
	*/
	public void setEstimateCall(java.lang.Object estimateCall){
		this.estimateCall = estimateCall;	
	}	
	
	
	
	
}

