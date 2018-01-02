package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.Config;

/**
 * @ClassName: Config
 * @Description: 系统配置服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public interface ConfigService {

    /**
	 * @Title: addConfig
	 * @Description:添加系统配置
	 * @param config 实体
	 * @return Integer
	 */
	Config addConfig(Config config);
	
	/**
	 * @Title modifyConfig
	 * @Description:修改系统配置
	 * @param config 实体
	 * @return Integer
	 */
	Integer modifyConfig(Config config);
	
	/**
	 * @Title: dropConfigByPropertyId
	 * @Description:删除系统配置
	 * @param propertyId 实体标识
	 * @return Integer
	 */
	Integer dropConfigByPropertyId(Integer propertyId);
	
	/**
	 * @Title: queryConfigByPropertyId
	 * @Description:根据实体标识查询系统配置
	 * @param propertyId 实体标识
	 * @return Config
	 */
	Config queryConfigByPropertyId(Integer propertyId);
	 
	/**
	 * @Title: queryConfigForPage
	 * @Description: 根据系统配置属性与分页信息分页查询系统配置信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param config 实体
	 * @return List<Config>
	 */
	Map<String, Object> queryConfigForPage(Integer pagenum, Integer pagesize, String sort, Config config);
	 
	 /**
	 * @Title: queryConfigByProperty
	 * @Description:根据属性查询系统配置
	 * @return List<Config>
	 */
	 List<Config> queryConfigByProperty(Map<String, Object> map);	 
	 
}
