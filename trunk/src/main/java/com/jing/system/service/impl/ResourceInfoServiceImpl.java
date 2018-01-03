package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.system.model.entity.ResourceInfo;
import com.jing.system.model.dao.ResourceInfoMapper;
import com.jing.system.service.ResourceInfoService;

/**
 * @ClassName: ResourceInfo
 * @Description: 资源菜单服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Service("resourceInfoService")
@Transactional(readOnly=true)
public class  ResourceInfoServiceImpl implements ResourceInfoService {

	@Autowired
    private ResourceInfoMapper resourceInfoMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addResourceInfo
	 * @Description:添加资源菜单
	 * @param resourceInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ResourceInfo addResourceInfo(ResourceInfo resourceInfo){
		int ret = resourceInfoMapper.addResourceInfo(resourceInfo);
		if(ret>0){
			return resourceInfo;
		}
		return null;
	}
	
	/**
	 * @Title modifyResourceInfo
	 * @Description:修改资源菜单
	 * @param resourceInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyResourceInfo(ResourceInfo resourceInfo){
		return resourceInfoMapper.modifyResourceInfo(resourceInfo);
	}
	
	/**
	 * @Title: dropResourceInfoByResourceId
	 * @Description:删除资源菜单
	 * @param resourceId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropResourceInfoByResourceId(Integer resourceId){
		return resourceInfoMapper.dropResourceInfoByResourceId(resourceId);
	}
	
	/**
	 * @Title: queryResourceInfoByResourceId
	 * @Description:根据实体标识查询资源菜单
	 * @param resourceId 实体标识
	 * @return ResourceInfo
	 */
	@Override
	public ResourceInfo queryResourceInfoByResourceId(Integer resourceId){
		return resourceInfoMapper.queryResourceInfoByResourceId(resourceId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryResourceInfoForPage
	 * @Description: 根据资源菜单属性与分页信息分页查询资源菜单信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param resourceInfo 实体
	 * @return List<ResourceInfo>
	 */
	@Override
	public Map<String, Object> queryResourceInfoForPage(Integer pagenum, Integer pagesize, String sort, ResourceInfo resourceInfo){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ResourceInfo.class);
		List<ResourceInfo> entityList = resourceInfoMapper.queryResourceInfoForPage(pageBounds, resourceInfo);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ResourceInfo.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ResourceInfo> pagelist = (PageList<ResourceInfo>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryResourceInfoByProperty
	 * @Description:根据属性查询资源菜单
	 * @return List<ResourceInfo>
	 */
	@Override
	public List<ResourceInfo> queryResourceInfoByProperty(Map<String, Object> map){
		return resourceInfoMapper.queryResourceInfoByProperty(map);
	}


}
