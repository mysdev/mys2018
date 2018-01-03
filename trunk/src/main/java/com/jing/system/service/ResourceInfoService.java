package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.ResourceInfo;

/**
 * @ClassName: ResourceInfo
 * @Description: 资源菜单服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public interface ResourceInfoService {

    /**
	 * @Title: addResourceInfo
	 * @Description:添加资源菜单
	 * @param resourceInfo 实体
	 * @return Integer
	 */
	ResourceInfo addResourceInfo(ResourceInfo resourceInfo);
	
	/**
	 * @Title modifyResourceInfo
	 * @Description:修改资源菜单
	 * @param resourceInfo 实体
	 * @return Integer
	 */
	Integer modifyResourceInfo(ResourceInfo resourceInfo);
	
	/**
	 * @Title: dropResourceInfoByResourceId
	 * @Description:删除资源菜单
	 * @param resourceId 实体标识
	 * @return Integer
	 */
	Integer dropResourceInfoByResourceId(Integer resourceId);
	
	/**
	 * @Title: queryResourceInfoByResourceId
	 * @Description:根据实体标识查询资源菜单
	 * @param resourceId 实体标识
	 * @return ResourceInfo
	 */
	ResourceInfo queryResourceInfoByResourceId(Integer resourceId);
	 
	/**
	 * @Title: queryResourceInfoForPage
	 * @Description: 根据资源菜单属性与分页信息分页查询资源菜单信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param resourceInfo 实体
	 * @return List<ResourceInfo>
	 */
	Map<String, Object> queryResourceInfoForPage(Integer pagenum, Integer pagesize, String sort, ResourceInfo resourceInfo);
	 
	 /**
	 * @Title: queryResourceInfoByProperty
	 * @Description:根据属性查询资源菜单
	 * @return List<ResourceInfo>
	 */
	 List<ResourceInfo> queryResourceInfoByProperty(Map<String, Object> map);	 
	 
}
