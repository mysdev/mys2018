package com.jing.settlement.model.entity;

public class PackagesDetailVo extends Goods{

	private static final long serialVersionUID = 1L;
	private Integer detailId;
	private String packageName;	//to_packages:package_name  套餐名称  
	private Integer goodsCt;	//to_packages_detail:goods_ct  商品数量  
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Integer getGoodsCt() {
		return goodsCt;
	}
	public void setGoodsCt(Integer goodsCt) {
		this.goodsCt = goodsCt;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	
}
