package com.jing.trade.model.entity;

import java.util.List;

import com.jing.settlement.model.entity.Merchandise;

/**
 * 账单
 * @author Lifeng
 *
 */
public class Bill {
	private List<Merchandise> merchandises;//消费单	
	private java.math.BigDecimal total;	//应付
	private java.math.BigDecimal original;//原价
	private java.math.BigDecimal preferential;//优惠幅度
	public List<Merchandise> getMerchandises() {
		return merchandises;
	}
	public void setMerchandises(List<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}
	public java.math.BigDecimal getTotal() {
		return total;
	}
	public void setTotal(java.math.BigDecimal total) {
		this.total = total;
	}
	public java.math.BigDecimal getOriginal() {
		return original;
	}
	public void setOriginal(java.math.BigDecimal original) {
		this.original = original;
	}
	public java.math.BigDecimal getPreferential() {
		return preferential;
	}
	public void setPreferential(java.math.BigDecimal preferential) {
		this.preferential = preferential;
	}
	
}
