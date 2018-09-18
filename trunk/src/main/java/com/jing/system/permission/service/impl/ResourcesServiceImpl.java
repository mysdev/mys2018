package com.jing.system.permission.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.dao.ResourcesDao;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.entity.VResources;
import com.jing.system.permission.service.ResourcesService;

@Service("resourcesService") 
public class ResourcesServiceImpl implements ResourcesService{

	@Resource
	private ResourcesDao resourcesDao;

	/**
	* 添加 系统资源（菜单、按钮）
	*/
	@Override
	public void addResources(Resources resources){
		resourcesDao.addResources(resources);
	}
	
	/**
	* 修改 系统资源（菜单、按钮）
	*/
	@Override
	public void updateResources(Resources resources){
		resourcesDao.updateResources(resources);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteResourcesById(Integer id){
		resourcesDao.deleteResourcesById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Resources getResourcesById(Integer id){
		return resourcesDao.getResourcesById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findResourcesListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(resourcesDao.findResourcesListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询系统资源（菜单、按钮）
	 * @param param
	 * @return
	 */
	 @Override
	public List<Resources> findResourcesList(Map<String, Object> param){
		return resourcesDao.findResourcesList(param);
	}
	 /**
	  * 查询所有系统资源
	  */
	@Override
	public List<Resources> getResourcesList() {
		return resourcesDao.getResourcesList();
	}
	
	@Override
	public List<VResources> getVResourcesList(String roleId) {
		return resourcesDao.getVResourcesList(roleId);
	}
	
}