package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Types;

@Mapper
public interface TypesMapper {

	/**
	* 添加 类型配置
	*/
	void addTypes(Types types);
	
	/**
	* 修改 类型配置
	*/
	void updateTypes(Types types);
	
	/**
	*根据ID删除记录
	*/
	void deleteTypesById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Types getTypesById(Integer id);
	
	/**
	* 分页查询
	*/
	List<Types> findTypesListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询类型配置
	 * @param param
	 * @return
	 */
	List<Types> findTypesList(@Param("param") Map<String, Object> param);	
}