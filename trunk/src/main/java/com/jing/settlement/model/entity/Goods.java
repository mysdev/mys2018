package com.jing.settlement.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Goods
 * @Description: 商品服务实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class Goods extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//to_goods:goods_id  商品标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsName;	//to_goods:goods_name  商品名称  

	private java.math.BigDecimal price;	//to_goods:price  商品售价  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer unitId;	//to_goods:unit_id  商品单位  

	private Integer goodsTime;	//to_goods:goods_time  服务时长 分  

	private Integer classify;	//to_goods:classify  商品小类  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer materialId;	//to_goods:material_id  原料标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer materialTypes;	//to_goods:material_types  原料类型(冗) 0物品1服务  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer materialCt;	//to_goods:material_ct  消耗原料数量 0不减库存  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//to_goods:status  状态 0正常  

	private Integer saleStatus;	//to_goods:sale_status  销售状态 推荐热销  

	@Length(min=0, max=512, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//to_goods:note  商品说明  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsImg;	//to_goods:goods_img  商品图例  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer isShow;	//to_goods:is_show  对客显示 0是  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer canCancel;	//to_goods:can_cancel  可否撤消 0是1否  


	/**
	* @DatabasetableColumnName: to_goods:goods_id
	* @Description: 获取属性        商品标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:goods_id
	* @Description: 设置属性        商品标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:goods_name
	* @Description: 获取属性        商品名称
	* @return: String
	*/
	public String getGoodsName(){
		return goodsName;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:goods_name
	* @Description: 设置属性        商品名称
	* @return: String
	*/
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:price
	* @Description: 获取属性        商品售价
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getPrice(){
		return price;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:price
	* @Description: 设置属性        商品售价
	* @return: java.math.BigDecimal
	*/
	public void setPrice(java.math.BigDecimal price){
		this.price = price;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:unit_id
	* @Description: 获取属性        商品单位
	* @return: Integer
	*/
	public Integer getUnitId(){
		return unitId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:unit_id
	* @Description: 设置属性        商品单位
	* @return: Integer
	*/
	public void setUnitId(Integer unitId){
		this.unitId = unitId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:goods_time
	* @Description: 获取属性        服务时长 分
	* @return: Integer
	*/
	public Integer getGoodsTime(){
		return goodsTime;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:goods_time
	* @Description: 设置属性        服务时长 分
	* @return: Integer
	*/
	public void setGoodsTime(Integer goodsTime){
		this.goodsTime = goodsTime;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:classify
	* @Description: 获取属性        商品小类
	* @return: Integer
	*/
	public Integer getClassify(){
		return classify;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:classify
	* @Description: 设置属性        商品小类
	* @return: Integer
	*/
	public void setClassify(Integer classify){
		this.classify = classify;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:material_id
	* @Description: 获取属性        原料标识
	* @return: Integer
	*/
	public Integer getMaterialId(){
		return materialId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:material_id
	* @Description: 设置属性        原料标识
	* @return: Integer
	*/
	public void setMaterialId(Integer materialId){
		this.materialId = materialId;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:material_types
	* @Description: 获取属性        原料类型(冗) 0物品1服务
	* @return: Integer
	*/
	public Integer getMaterialTypes(){
		return materialTypes;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:material_types
	* @Description: 设置属性        原料类型(冗) 0物品1服务
	* @return: Integer
	*/
	public void setMaterialTypes(Integer materialTypes){
		this.materialTypes = materialTypes;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:material_ct
	* @Description: 获取属性        消耗原料数量 0不减库存
	* @return: Integer
	*/
	public Integer getMaterialCt(){
		return materialCt;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:material_ct
	* @Description: 设置属性        消耗原料数量 0不减库存
	* @return: Integer
	*/
	public void setMaterialCt(Integer materialCt){
		this.materialCt = materialCt;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:sale_status
	* @Description: 获取属性        销售状态 推荐热销
	* @return: Integer
	*/
	public Integer getSaleStatus(){
		return saleStatus;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:sale_status
	* @Description: 设置属性        销售状态 推荐热销
	* @return: Integer
	*/
	public void setSaleStatus(Integer saleStatus){
		this.saleStatus = saleStatus;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:note
	* @Description: 获取属性        商品说明
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:note
	* @Description: 设置属性        商品说明
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:goods_img
	* @Description: 获取属性        商品图例
	* @return: String
	*/
	public String getGoodsImg(){
		return goodsImg;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:goods_img
	* @Description: 设置属性        商品图例
	* @return: String
	*/
	public void setGoodsImg(String goodsImg){
		this.goodsImg = goodsImg;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:is_show
	* @Description: 获取属性        对客显示 0是
	* @return: Integer
	*/
	public Integer getIsShow(){
		return isShow;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:is_show
	* @Description: 设置属性        对客显示 0是
	* @return: Integer
	*/
	public void setIsShow(Integer isShow){
		this.isShow = isShow;	
	}	
	/**
	* @DatabasetableColumnName: to_goods:can_cancel
	* @Description: 获取属性        可否撤消 0是1否
	* @return: Integer
	*/
	public Integer getCanCancel(){
		return canCancel;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods:can_cancel
	* @Description: 设置属性        可否撤消 0是1否
	* @return: Integer
	*/
	public void setCanCancel(Integer canCancel){
		this.canCancel = canCancel;	
	}	
	
	
	
	
}

