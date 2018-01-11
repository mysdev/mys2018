package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.Packages;

/**
 * @ClassName: PackagesMapper
 * @Description: 消费套餐映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface PackagesMapper {

	/**
	 * @Title: addPackages
	 * @Description:添加消费套餐
	 * @param packages 实体
	 * @return Integer
	 */
	Integer addPackages(Packages packages);
	
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
	 * @param pageBounds 分页信息
	 * @param packages 实体
	 * @return List<Packages>
	 */
	List<Packages> queryPackagesForPage(PageBounds pageBounds, @Param("packages") Packages packages);
	 
	 /**
	  * @Title: queryPackagesByProperty
	  * @Description:根据属性查询消费套餐
	  * @return List<Packages>
	  */
	 List<Packages> queryPackagesByProperty(@Param("packages") Map<String, Object> map);
	 
	 
	 
}
