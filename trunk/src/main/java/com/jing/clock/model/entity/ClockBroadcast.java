package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: ClockBroadcast
 * @Description: 报钟播报实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class ClockBroadcast extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer broadcastId;	//tc_clock_broadcast:broadcast_id  记录标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tc_clock_broadcast:store_id  归属门店  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=9, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer stauts;	//tc_clock_broadcast:stauts  记录状态 0待播 播放次数  

	@Range(min=0, max=9, message = "{org.hibernate.validator.constraints.Range.message}")
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
	* @DatabasetableColumnName: tc_clock_broadcast:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_broadcast:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
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

