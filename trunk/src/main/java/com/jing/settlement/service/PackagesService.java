package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.Packages;

/**
 * @ClassName: Packages
 * @Description: 消费套餐服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface PackagesService {

    /**
	 * @Title: addPackages
	 * @Description:添加消费套餐
	 * @param packages 实体
	 * @return Integer
	 */
	Packages addPackages(Packages packages);
	
	/**
	 * @Title modifyPackages
	 * @Description:修改消费套餐
	 * @param packages 实体
	 * @return Integer
	 */
	Integer modifyPackages(Packages packages);
	
	/**
	 * @Title: dropPackagesByPackageId
	 * @Description:删除消费套餐
	 * @param packageId 实体标识
	 * @return Integer
	 */
	Integer dropPackagesByPackageId(String packageId);
	
	/**
	 * @Title: queryPackagesByPackageId
	 * @Description:根据实体标识查询消费套餐
	 * @param packageId 实体标识
	 * @return Packages
	 */
	Packages queryPackagesByPackageId(String packageId);
	 
	/**
	 * @Title: queryPackagesForPage
	 * @Description: 根据消费套餐属性与分页信息分页查询消费套餐信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param packages 实体
	 * @return List<Packages>
	 */
	Map<String, Object> queryPackagesForPage(Integer pagenum, Integer pagesize, String sort, Packages packages);
	 
	 /**
	 * @Title: queryPackagesByProperty
	 * @Description:根据属性查询消费套餐
	 * @return List<Packages>
	 */
	 List<Packages> queryPackagesByProperty(Map<String, Object> map);	 
	 
}
