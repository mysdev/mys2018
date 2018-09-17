package com.jing.settlement.model.entity;

import org.hibernate.validator.constraints.Length;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: GoodsExt
 * @Description: 商品服务扩展实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class GoodsExt extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//to_goods_ext:goods_id  商品标识  


	/**
	* @DatabasetableColumnName: to_goods_ext:goods_id
	* @Description: 获取属性        商品标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: to_goods_ext:goods_id
	* @Description: 设置属性        商品标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}	
	
	
	
	
}

