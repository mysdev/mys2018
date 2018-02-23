package com.jing.settlement.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: GoodsMaterial
 * @Description: 基本原料实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class GoodsMaterial extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer materialId;	//to_goods_material:material_id  原料标识  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//to_goods_material:store_id  归属门店  

	@Length(min=0, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String materialName;	//to_goods_material:material_name  原料名称  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String materialNo;	//to_goods_material:material_no  原料代码  

	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer materialTypes;	//to_goods_material:material_types  原料类型 0物品1服务  

	private Integer materialCt;	//to_goods_material:material_ct  原料库存  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String pinyin;	//to_goods_material:pinyin  拼音  

	private java.math.BigDecimal cost;	//to_goods_material:cost  纯成本  

	private java.math.BigDecimal costAll;	//to_goods_material:cost_all  核算成本  


	/**
	* @DatabasetableColumnName: to_goods_material:material_id
	* @Description: 获取属性        原料标识
	* @return: Integer
	*/
	public Integer getMaterialId(){
		return materialId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:material_id
	* @Description: 设置属性        原料标识
	* @return: Integer
	*/
	public void setMaterialId(Integer materialId){
		this.materialId = materialId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:material_name
	* @Description: 获取属性        原料名称
	* @return: String
	*/
	public String getMaterialName(){
		return materialName;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:material_name
	* @Description: 设置属性        原料名称
	* @return: String
	*/
	public void setMaterialName(String materialName){
		this.materialName = materialName;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:material_no
	* @Description: 获取属性        原料代码
	* @return: String
	*/
	public String getMaterialNo(){
		return materialNo;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:material_no
	* @Description: 设置属性        原料代码
	* @return: String
	*/
	public void setMaterialNo(String materialNo){
		this.materialNo = materialNo;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:material_types
	* @Description: 获取属性        原料类型 0物品1服务
	* @return: Integer
	*/
	public Integer getMaterialTypes(){
		return materialTypes;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:material_types
	* @Description: 设置属性        原料类型 0物品1服务
	* @return: Integer
	*/
	public void setMaterialTypes(Integer materialTypes){
		this.materialTypes = materialTypes;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:material_ct
	* @Description: 获取属性        原料库存
	* @return: Integer
	*/
	public Integer getMaterialCt(){
		return materialCt;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:material_ct
	* @Description: 设置属性        原料库存
	* @return: Integer
	*/
	public void setMaterialCt(Integer materialCt){
		this.materialCt = materialCt;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:pinyin
	* @Description: 获取属性        拼音
	* @return: String
	*/
	public String getPinyin(){
		return pinyin;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:pinyin
	* @Description: 设置属性        拼音
	* @return: String
	*/
	public void setPinyin(String pinyin){
		this.pinyin = pinyin;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:cost
	* @Description: 获取属性        纯成本
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getCost(){
		return cost;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:cost
	* @Description: 设置属性        纯成本
	* @return: java.math.BigDecimal
	*/
	public void setCost(java.math.BigDecimal cost){
		this.cost = cost;	
	}	
	/**
	* @DatabasetableColumnName: to_goods_material:cost_all
	* @Description: 获取属性        核算成本
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getCostAll(){
		return costAll;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_material:cost_all
	* @Description: 设置属性        核算成本
	* @return: java.math.BigDecimal
	*/
	public void setCostAll(java.math.BigDecimal costAll){
		this.costAll = costAll;	
	}	
	
	
	
	
}

