package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.GoodsMaterial;

@Mapper
public interface GoodsMaterialMapper {

	/**
	* 添加 基本原料
	*/
	void addGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	* 修改 基本原料
	*/
	void updateGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	*根据ID删除记录
	*/
	void deleteGoodsMaterialById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	GoodsMaterial getGoodsMaterialById(Integer id);
	
	/**
	* 分页查询
	*/
	List<GoodsMaterial> findGoodsMaterialListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询基本原料
	 * @param param
	 * @return
	 */
	List<GoodsMaterial> findGoodsMaterialList(@Param("param") Map<String, Object> param);	
}