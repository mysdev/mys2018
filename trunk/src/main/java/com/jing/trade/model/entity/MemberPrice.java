package com.jing.trade.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: MemberPrice
 * @Description: 会员价格实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class MemberPrice extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer priceId;	//tt_member_price:price_id  自增标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer levelId;	//tt_member_price:level_id  会员等级标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectType;	//tt_member_price:object_type  估价类型1商品服务2套餐  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tt_member_price:object_id  对象标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal price;	//tt_member_price:price  会员价格  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal discount;	//tt_member_price:discount  优惠金额  


	/**
	* @DatabasetableColumnName: tt_member_price:price_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getPriceId(){
		return priceId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:price_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setPriceId(Integer priceId){
		this.priceId = priceId;	
	}	
	/**
	* @DatabasetableColumnName: tt_member_price:level_id
	* @Description: 获取属性        会员等级标识
	* @return: Integer
	*/
	public Integer getLevelId(){
		return levelId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:level_id
	* @Description: 设置属性        会员等级标识
	* @return: Integer
	*/
	public void setLevelId(Integer levelId){
		this.levelId = levelId;	
	}	
	/**
	* @DatabasetableColumnName: tt_member_price:object_type
	* @Description: 获取属性        估价类型1商品服务2套餐
	* @return: Integer
	*/
	public Integer getObjectType(){
		return objectType;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:object_type
	* @Description: 设置属性        估价类型1商品服务2套餐
	* @return: Integer
	*/
	public void setObjectType(Integer objectType){
		this.objectType = objectType;	
	}	
	/**
	* @DatabasetableColumnName: tt_member_price:object_id
	* @Description: 获取属性        对象标识
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:object_id
	* @Description: 设置属性        对象标识
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tt_member_price:price
	* @Description: 获取属性        会员价格
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getPrice(){
		return price;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:price
	* @Description: 设置属性        会员价格
	* @return: java.math.BigDecimal
	*/
	public void setPrice(java.math.BigDecimal price){
		this.price = price;	
	}	
	/**
	* @DatabasetableColumnName: tt_member_price:discount
	* @Description: 获取属性        优惠金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDiscount(){
		return discount;	
	}
	
	/**
	* @DatabasetableColumnName: tt_member_price:discount
	* @Description: 设置属性        优惠金额
	* @return: java.math.BigDecimal
	*/
	public void setDiscount(java.math.BigDecimal discount){
		this.discount = discount;	
	}	
	
	
	
	
}

