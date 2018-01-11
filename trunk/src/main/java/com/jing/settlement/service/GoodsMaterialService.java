package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.GoodsMaterial;

/**
 * @ClassName: GoodsMaterial
 * @Description: 基本原料服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface GoodsMaterialService {

    /**
	 * @Title: addGoodsMaterial
	 * @Description:添加基本原料
	 * @param goodsMaterial 实体
	 * @return Integer
	 */
	GoodsMaterial addGoodsMaterial(GoodsMaterial goodsMaterial);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsMaterial 实体
	 * @return List<GoodsMaterial>
	 */
	Map<String, Object> queryGoodsMaterialForPage(Integer pagenum, Integer pagesize, String sort, GoodsMaterial goodsMaterial);
	 
	 /**
	 * @Title: queryGoodsMaterialByProperty
	 * @Description:根据属性查询基本原料
	 * @return List<GoodsMaterial>
	 */
	 List<GoodsMaterial> queryGoodsMaterialByProperty(Map<String, Object> map);	 
	 
}
