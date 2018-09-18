package com.jing.system.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.entity.VResources;

@Mapper
public interface ResourcesDao {

	/**
	* 添加 系统资源（菜单、按钮）
	*/
	void addResources(Resources resources);
	
	/**
	* 修改 系统资源（菜单、按钮）
	*/
	void updateResources(Resources resources);
	
	/**
	*根据ID删除记录
	*/
	void deleteResourcesById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Resources getResourcesById(Integer id);
	
	/**
	* 分页查询
	*/
	List<Resources> findResourcesListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询系统资源（菜单、按钮）
	 * @param param
	 * @return
	 */
	List<Resources> findResourcesList(@Param("param") Map<String, Object> param);
	/**
	 * 查询所有的系统资源
	 * @return
	 */
	List<Resources> getResourcesList();
	
	List<VResources> getVResourcesList(String roleId);
	
	 
}