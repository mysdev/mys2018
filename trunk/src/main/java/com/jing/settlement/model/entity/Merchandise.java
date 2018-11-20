package com.jing.settlement.model.entity;

import java.math.BigDecimal;

public class Merchandise {
	
	private Integer gspType;//商品/服务/套餐
	private String gpId;//商品或者套餐ID
	private String name;//名称
	private java.math.BigDecimal price;	//to_packages:price  单价
	private java.math.BigDecimal originalPrice;//原单价
	private int quantity;//数量
	private java.math.BigDecimal totalPrice;//总价
	public Integer getGspType() {
		return gspType;
	}
	public void setGspType(Integer gspType) {
		this.gspType = gspType;
	}
	public String getGpId() {
		return gpId;
	}
	public void setGpId(String gpId) {
		this.gpId = gpId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.math.BigDecimal getPrice() {
		return price;
	}
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	public java.math.BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(java.math.BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public java.math.BigDecimal getTotalPrice() {
		if(totalPrice==null ) {
			return price.multiply(new BigDecimal(quantity));
		}
		return totalPrice;
	}
}
