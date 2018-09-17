package com.jing.settlement.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: GoodsUnit
 * @Description: 商品单位实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class GoodsUnit extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer unitId;	//to_goods_unit:unit_id  单位标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String unitName;	//to_goods_unit:unit_name  单位名称  

	private Integer baseUnit;	//to_goods_unit:base_unit  基准单位  

	private Integer baseCt;	//to_goods_unit:base_ct  换算比 与基准单位  


	/**
	* @DatabasetableColumnName: to_goods_unit:unit_id
	* @Description: 获取属性        单位标识
	* @return: Integer
	*/
	public Integer getUnitId(){
		return unitId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_unit:unit_id
	* @Description: 设置属性        单位标识
	* @return: Integer
	*/
	public void setUnitId(Integer unitId){
		this.unitId = unitId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_unit:unit_name
	* @Description: 获取属性        单位名称
	* @return: String
	*/
	public String getUnitName(){
		return unitName;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_unit:unit_name
	* @Description: 设置属性        单位名称
	* @return: String
	*/
	public void setUnitName(String unitName){
		this.unitName = unitName;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_unit:base_unit
	* @Description: 获取属性        基准单位
	* @return: Integer
	*/
	public Integer getBaseUnit(){
		return baseUnit;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_unit:base_unit
	* @Description: 设置属性        基准单位
	* @return: Integer
	*/
	public void setBaseUnit(Integer baseUnit){
		this.baseUnit = baseUnit;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_unit:base_ct
	* @Description: 获取属性        换算比 与基准单位
	* @return: Integer
	*/
	public Integer getBaseCt(){
		return baseCt;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_unit:base_ct
	* @Description: 设置属性        换算比 与基准单位
	* @return: Integer
	*/
	public void setBaseCt(Integer baseCt){
		this.baseCt = baseCt;	
	}	
	
	
	
	
}

