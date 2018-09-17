package com.jing.trade.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Exchange
 * @Description: 结算币种实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Exchange extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer exchangeId;	//tt_exchange:exchange_id  汇率标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String exchangeName;	//tt_exchange:exchange_name  汇率币种  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal exchangeRate;	//tt_exchange:exchange_rate  汇率  


	/**
	* @DatabasetableColumnName: tt_exchange:exchange_id
	* @Description: 获取属性        汇率标识
	* @return: Integer
	*/
	public Integer getExchangeId(){
		return exchangeId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_exchange:exchange_id
	* @Description: 设置属性        汇率标识
	* @return: Integer
	*/
	public void setExchangeId(Integer exchangeId){
		this.exchangeId = exchangeId;	
	}	
	/**
	* @DatabasetableColumnName: tt_exchange:exchange_name
	* @Description: 获取属性        汇率币种
	* @return: String
	*/
	public String getExchangeName(){
		return exchangeName;	
	}
	
	/**
	* @DatabasetableColumnName: tt_exchange:exchange_name
	* @Description: 设置属性        汇率币种
	* @return: String
	*/
	public void setExchangeName(String exchangeName){
		this.exchangeName = exchangeName;	
	}	
	/**
	* @DatabasetableColumnName: tt_exchange:exchange_rate
	* @Description: 获取属性        汇率
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getExchangeRate(){
		return exchangeRate;	
	}
	
	/**
	* @DatabasetableColumnName: tt_exchange:exchange_rate
	* @Description: 设置属性        汇率
	* @return: java.math.BigDecimal
	*/
	public void setExchangeRate(java.math.BigDecimal exchangeRate){
		this.exchangeRate = exchangeRate;	
	}	
	
	
	
	
}

