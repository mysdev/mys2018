package com.jing.system.permission.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.entity.VResources;

public interface ResourcesService {

	/**
	 * 添加 系统资源（菜单、按钮）
	 */
	void addResources(Resources resources);

	/**
	 * 修改 系统资源（菜单、按钮）
	 */
	void updateResources(Resources resources);

	/**
	 * 根据ID删除记录
	 */
	void deleteResourcesById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	Resources getResourcesById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findResourcesListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询系统资源（菜单、按钮）
	 * 
	 * @param param
	 * @return
	 */
	List<Resources> findResourcesList(Map<String, Object> param);

	/**
	 * 查询所有系统资源
	 * 
	 * @return
	 */
	List<Resources> getResourcesList();
	
	/**
	 * 查询所有系统资源  带权限
	 * 
	 * @return
	 */
	List<VResources> getVResourcesList(String roleId);

}