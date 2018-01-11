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
 * @ClassName: ClockBroadcast
 * @Description: 报钟播报实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class ClockBroadcast extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer broadcastId;	//tc_clock_broadcast:broadcast_id  记录标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer stauts;	//tc_clock_broadcast:stauts  记录状态 0待播 播放次数  

	private Integer types;	//tc_clock_broadcast:types  播报类型  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String content;	//tc_clock_broadcast:content  播报内容  


	/**
	* @DatabasetableColumnName: tc_clock_broadcast:broadcast_id
	* @Description: 获取属性        记录标识
	* @return: Integer
	*/
	public Integer getBroadcastId(){
		return broadcastId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:broadcast_id
	* @Description: 设置属性        记录标识
	* @return: Integer
	*/
	public void setBroadcastId(Integer broadcastId){
		this.broadcastId = broadcastId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:stauts
	* @Description: 获取属性        记录状态 0待播 播放次数
	* @return: Integer
	*/
	public Integer getStauts(){
		return stauts;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:stauts
	* @Description: 设置属性        记录状态 0待播 播放次数
	* @return: Integer
	*/
	public void setStauts(Integer stauts){
		this.stauts = stauts;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:types
	* @Description: 获取属性        播报类型
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:types
	* @Description: 设置属性        播报类型
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:content
	* @Description: 获取属性        播报内容
	* @return: String
	*/
	public String getContent(){
		return content;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:content
	* @Description: 设置属性        播报内容
	* @return: String
	*/
	public void setContent(String content){
		this.content = content;	
	}	
	
	
	
	
}

