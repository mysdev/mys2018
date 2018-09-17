package com.jing.utils;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
 * @ClassName: BaseEntity
 * @Description: 数据用公共父类
 * @author: Jinlong He
 * @date: 2018年1月11日 下午3:07:45
 */
public class BaseEntity implements Serializable {	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private Integer createdBy;	//tt_coupon:created_by  创建人员  
	
	private Date createdDate;	//tt_coupon:created_date  创建时间  
	
	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private Integer updatedBy;	//tt_coupon:updated_by  修订人员  

	private Date updatedDate;	//tt_coupon:updated_date  修订时间 
	
	/**
	* @DatabasetableColumnName: tt_coupon:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public Integer getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(Integer createdBy){
		this.createdBy = createdBy;	
	}	

	/**
	* @DatabasetableColumnName: tt_coupon:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}	

	/**
	* @DatabasetableColumnName: tt_coupon:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public Integer getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(Integer updatedBy){
		this.updatedBy = updatedBy;	
	}	

	/**
	* @DatabasetableColumnName: tt_coupon:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}	
	
	public void setCreatedDateNow(){
		this.createdDate = new Date();
	}
	
	public void setUpdatedDateNow(){
		this.updatedDate = new Date();
	}
}
