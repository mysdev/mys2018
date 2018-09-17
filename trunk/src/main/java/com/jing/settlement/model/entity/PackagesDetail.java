package com.jing.settlement.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: PackagesDetail
 * @Description: 消费套餐详情实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class PackagesDetail extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer detailId;	//to_packages_detail:detail_id  详情标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String packageId;	//to_packages_detail:package_id  归属套餐  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//to_packages_detail:goods_id  商品标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer goodsCt;	//to_packages_detail:goods_ct  商品数量  


	/**
	* @DatabasetableColumnName: to_packages_detail:detail_id
	* @Description: 获取属性        详情标识
	* @return: Integer
	*/
	public Integer getDetailId(){
		return detailId;	
	}
	
	/**
	* @DatabasetableColumnName: to_packages_detail:detail_id
	* @Description: 设置属性        详情标识
	* @return: Integer
	*/
	public void setDetailId(Integer detailId){
		this.detailId = detailId;	
	}	
	/**
	* @DatabasetableColumnName: to_packages_detail:package_id
	* @Description: 获取属性        归属套餐
	* @return: String
	*/
	public String getPackageId(){
		return packageId;	
	}
	
	/**
	* @DatabasetableColumnName: to_packages_detail:package_id
	* @Description: 设置属性        归属套餐
	* @return: String
	*/
	public void setPackageId(String packageId){
		this.packageId = packageId;	
	}	
	/**
	* @DatabasetableColumnName: to_packages_detail:goods_id
	* @Description: 获取属性        商品标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: to_packages_detail:goods_id
	* @Description: 设置属性        商品标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}	
	/**
	* @DatabasetableColumnName: to_packages_detail:goods_ct
	* @Description: 获取属性        商品数量
	* @return: Integer
	*/
	public Integer getGoodsCt(){
		return goodsCt;	
	}
	
	/**
	* @DatabasetableColumnName: to_packages_detail:goods_ct
	* @Description: 设置属性        商品数量
	* @return: Integer
	*/
	public void setGoodsCt(Integer goodsCt){
		this.goodsCt = goodsCt;	
	}	
	
	
	
	
}

