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
 * @ClassName: Volume
 * @Description: 优惠券实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Volume extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer volumeId;	//tt_volume:volume_id  卷号  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String volumeCode;	//tt_volume:volume_code  卷编号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer couponId;	//tt_volume:coupon_id  券组标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tt_volume:status  状态 0正常 1使用  


	/**
	* @DatabasetableColumnName: tt_volume:volume_id
	* @Description: 获取属性        卷号
	* @return: Integer
	*/
	public Integer getVolumeId(){
		return volumeId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_volume:volume_id
	* @Description: 设置属性        卷号
	* @return: Integer
	*/
	public void setVolumeId(Integer volumeId){
		this.volumeId = volumeId;	
	}	
	/**
	* @DatabasetableColumnName: tt_volume:volume_code
	* @Description: 获取属性        卷编号
	* @return: String
	*/
	public String getVolumeCode(){
		return volumeCode;	
	}
	
	/**
	* @DatabasetableColumnName: tt_volume:volume_code
	* @Description: 设置属性        卷编号
	* @return: String
	*/
	public void setVolumeCode(String volumeCode){
		this.volumeCode = volumeCode;	
	}	
	/**
	* @DatabasetableColumnName: tt_volume:coupon_id
	* @Description: 获取属性        券组标识
	* @return: Integer
	*/
	public Integer getCouponId(){
		return couponId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_volume:coupon_id
	* @Description: 设置属性        券组标识
	* @return: Integer
	*/
	public void setCouponId(Integer couponId){
		this.couponId = couponId;	
	}	
	/**
	* @DatabasetableColumnName: tt_volume:status
	* @Description: 获取属性        状态 0正常 1使用
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tt_volume:status
	* @Description: 设置属性        状态 0正常 1使用
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

