package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.GoodsMaterial;

/**
 * @ClassName: GoodsMaterialMapper
 * @Description: 基本原料映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface GoodsMaterialMapper {

	/**
	 * @Title: addGoodsMaterial
	 * @Description:添加基本原料
	 * @param goodsMaterial 实体
	 * @return Integer
	 */
	Integer addGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	 * @Title modifyGoodsMaterial
	 * @Description:修改基本原料
	 * @param goodsMaterial 实体
	 * @return Integer
	 */
	Integer modifyGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	 * @Title: dropGoodsMaterialByMaterialId
	 * @Description:删除基本原料
	 * @param materialId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsMaterialByMaterialId(Integer materialId);
	
	/**
	 * @Title: queryGoodsMaterialByMaterialId
	 * @Description:根据实体标识查询基本原料
	 * @param materialId 实体标识
	 * @return GoodsMaterial
	 */
	GoodsMaterial queryGoodsMaterialByMaterialId(Integer materialId);
	 
	/**
	 * @Title: queryGoodsMaterialForPage
	 * @Description: 根据基本原料属性与分页信息分页查询基本原料信息
	 * @param pageBounds 分页信息
	 * @param goodsMaterial 实体
	 * @return List<GoodsMaterial>
	 */
	List<GoodsMaterial> queryGoodsMaterialForPage(PageBounds pageBounds, @Param("goodsMaterial") GoodsMaterial goodsMaterial);
	 
	 /**
	  * @Title: queryGoodsMaterialByProperty
	  * @Description:根据属性查询基本原料
	  * @return List<GoodsMaterial>
	  */
	 List<GoodsMaterial> queryGoodsMaterialByProperty(@Param("goodsMaterial") Map<String, Object> map);
	 
	 
	 
}
