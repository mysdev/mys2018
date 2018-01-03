package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.ResourceInfo;

/**
 * @ClassName: ResourceInfoMapper
 * @Description: 资源菜单映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Mapper
public interface ResourceInfoMapper {

	/**
	 * @Title: addResourceInfo
	 * @Description:添加资源菜单
	 * @param resourceInfo 实体
	 * @return Integer
	 */
	Integer addResourceInfo(ResourceInfo resourceInfo);
	
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
	 * @param pageBounds 分页信息
	 * @param resourceInfo 实体
	 * @return List<ResourceInfo>
	 */
	List<ResourceInfo> queryResourceInfoForPage(PageBounds pageBounds, @Param("resourceInfo") ResourceInfo resourceInfo);
	 
	 /**
	  * @Title: queryResourceInfoByProperty
	  * @Description:根据属性查询资源菜单
	  * @return List<ResourceInfo>
	  */
	 List<ResourceInfo> queryResourceInfoByProperty(@Param("resourceInfo") Map<String, Object> map);
	 
	 
	 
}
