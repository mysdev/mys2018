package com.jing.settlement.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Packages;

public interface PackagesService {
	
	/**
	 * 重置原价和优惠幅度
	 * @param packageId
	 */
	void resetprice(String packageId);

	/**
	* 添加 消费套餐
	*/
	void addPackages(Packages packages);
	
	/**
	* 修改 消费套餐
	*/
	void updatePackages(Packages packages);
	
	/**
	*根据ID删除记录
	*/
	void deletePackagesById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Packages getPackagesById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findPackagesListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询消费套餐
	 * @param param
	 * @return
	 */
	List<Packages> findPackagesList(Map<String, Object> param);
}