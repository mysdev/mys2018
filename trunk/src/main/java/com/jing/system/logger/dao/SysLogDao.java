package com.jing.system.logger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.logger.entity.SysLog;

@Mapper
public interface SysLogDao {

	/**
	* 添加 系统操作日志
	*/
	void addSysLog(SysLog sysLog);
	
	/**
	* 修改 系统操作日志
	*/
	void updateSysLog(SysLog sysLog);
	
	/**
	*根据ID删除记录
	*/
	void deleteSysLogById(String id);	
	
	/**
	*根据ID查询记录
	*/
	SysLog getSysLogById(String id);
	
	/**
	* 分页查询
	*/
	List<SysLog> findSysLogListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询系统操作日志
	 * @param param
	 * @return
	 */
	List<SysLog> findSysLogList(@Param("param") Map<String, Object> param);	
}