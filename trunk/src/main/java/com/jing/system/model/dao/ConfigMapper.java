package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.Config;

/**
 * @ClassName: ConfigMapper
 * @Description: 系统配置映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Mapper
public interface ConfigMapper {

	/**
	 * @Title: addConfig
	 * @Description:添加系统配置
	 * @param config 实体
	 * @return Integer
	 */
	Integer addConfig(Config config);
	
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
	 * @param pageBounds 分页信息
	 * @param config 实体
	 * @return List<Config>
	 */
	List<Config> queryConfigForPage(PageBounds pageBounds, @Param("config") Config config);
	 
	 /**
	  * @Title: queryConfigByProperty
	  * @Description:根据属性查询系统配置
	  * @return List<Config>
	  */
	 List<Config> queryConfigByProperty(@Param("config") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}
