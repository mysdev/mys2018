package com.jing.system.sysconfig.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.sysconfig.entity.SysConfig;

@Mapper
public interface SysConfigDao {

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
	List<SysConfig> findSysConfigListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询系统参数
	 * @param param
	 * @return
	 */
	List<SysConfig> findSysConfigList(@Param("param") Map<String, Object> param);	
}