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


import com.jing.system.model.entity.Config;
import com.jing.system.model.dao.ConfigMapper;
import com.jing.system.service.ConfigService;

/**
 * @ClassName: Config
 * @Description: 系统配置服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Service("configService")
@Transactional(readOnly=true)
public class  ConfigServiceImpl implements ConfigService {

	@Autowired
    private ConfigMapper configMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addConfig
	 * @Description:添加系统配置
	 * @param config 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Config addConfig(Config config){
		int ret = configMapper.addConfig(config);
		if(ret>0){
			return config;
		}
		return null;
	}
	
	/**
	 * @Title modifyConfig
	 * @Description:修改系统配置
	 * @param config 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyConfig(Config config){
		return configMapper.modifyConfig(config);
	}
	
	/**
	 * @Title: dropConfigByPropertyId
	 * @Description:删除系统配置
	 * @param propertyId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropConfigByPropertyId(Integer propertyId){
		return configMapper.dropConfigByPropertyId(propertyId);
	}
	
	/**
	 * @Title: queryConfigByPropertyId
	 * @Description:根据实体标识查询系统配置
	 * @param propertyId 实体标识
	 * @return Config
	 */
	@Override
	public Config queryConfigByPropertyId(Integer propertyId){
		return configMapper.queryConfigByPropertyId(propertyId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryConfigForPage
	 * @Description: 根据系统配置属性与分页信息分页查询系统配置信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param config 实体
	 * @return List<Config>
	 */
	@Override
	public Map<String, Object> queryConfigForPage(Integer pagenum, Integer pagesize, String sort, Config config){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Config.class);
		List<Config> entityList = configMapper.queryConfigForPage(pageBounds, config);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Config.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Config> pagelist = (PageList<Config>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryConfigByProperty
	 * @Description:根据属性查询系统配置
	 * @return List<Config>
	 */
	@Override
	public List<Config> queryConfigByProperty(Map<String, Object> map){
		return configMapper.queryConfigByProperty(map);
	}


}
