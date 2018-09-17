package com.jing.system.sysconfig.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.sysconfig.entity.SysConfig;

public interface SysConfigService {

	/**
	* 添加 系统参数
	*/
	void addSysConfig(SysConfig sysConfig);
	
	/**
	* 修改 系统参数
	*/
	void updateSysConfig(SysConfig sysConfig);
	
	/**
	*根据ID删除记录
	*/
	void deleteSysConfigById(String id);	
	
	/**
	*根据ID查询记录
	*/
	SysConfig getSysConfigById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findSysConfigListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询系统参数
	 * @param param
	 * @return
	 */
	List<SysConfig> findSysConfigList(Map<String, Object> param);
}