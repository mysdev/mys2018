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
 * @ClassName: ReservationTrade
 * @Description: 消费商品详情实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class ReservationTrade extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer detailId;	//tb_reservation_trade:detail_id  消费标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String authorizationId;	//tb_reservation_trade:authorization_id  授权码  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer types;	//tb_reservation_trade:types  交易类型 0商品1服务9套餐  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tb_reservation_trade:object_id  交易物品标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectCt;	//tb_reservation_trade:object_ct  交易数量  

	private Integer canCancel;	//tb_reservation_trade:can_cancel  可否撤消 0是 1否  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_reservation_trade:status  详情状态 0正常 1取消  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//tb_reservation_trade:note  备注  


	/**
	* @DatabasetableColumnName: tb_reservation_trade:detail_id
	* @Description: 获取属性        消费标识
	* @return: Integer
	*/
	public Integer getDetailId(){
		return detailId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:detail_id
	* @Description: 设置属性        消费标识
	* @return: Integer
	*/
	public void setDetailId(Integer detailId){
		this.detailId = detailId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:authorization_id
	* @Description: 获取属性        授权码
	* @return: String
	*/
	public String getAuthorizationId(){
		return authorizationId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:authorization_id
	* @Description: 设置属性        授权码
	* @return: String
	*/
	public void setAuthorizationId(String authorizationId){
		this.authorizationId = authorizationId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:types
	* @Description: 获取属性        交易类型 0商品1服务9套餐
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:types
	* @Description: 设置属性        交易类型 0商品1服务9套餐
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:object_id
	* @Description: 获取属性        交易物品标识
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:object_id
	* @Description: 设置属性        交易物品标识
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:object_ct
	* @Description: 获取属性        交易数量
	* @return: Integer
	*/
	public Integer getObjectCt(){
		return objectCt;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:object_ct
	* @Description: 设置属性        交易数量
	* @return: Integer
	*/
	public void setObjectCt(Integer objectCt){
		this.objectCt = objectCt;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:can_cancel
	* @Description: 获取属性        可否撤消 0是 1否
	* @return: Integer
	*/
	public Integer getCanCancel(){
		return canCancel;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:can_cancel
	* @Description: 设置属性        可否撤消 0是 1否
	* @return: Integer
	*/
	public void setCanCancel(Integer canCancel){
		this.canCancel = canCancel;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:status
	* @Description: 获取属性        详情状态 0正常 1取消
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:status
	* @Description: 设置属性        详情状态 0正常 1取消
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:note
	* @Description: 获取属性        备注
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: tb_reservation_trade:note
	* @Description: 设置属性        备注
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}	
	
	
	
	
}

