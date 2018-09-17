package com.jing.system.sysconfig.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.sysconfig.SysConfigMapper;
import com.jing.system.sysconfig.dao.SysConfigDao;
import com.jing.system.sysconfig.entity.SysConfig;
import com.jing.system.sysconfig.service.SysConfigService;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService{

	@Resource
	private SysConfigDao sysConfigDao;

	/**
	* 添加 系统参数
	*/
	@Override
	public void addSysConfig(SysConfig sysConfig){
		sysConfigDao.addSysConfig(sysConfig);
		SysConfigMapper.setValue(sysConfig.getPcode(), sysConfig.getPvalue());
	}
	
	/**
	* 修改 系统参数
	*/
	@Override
	public void updateSysConfig(SysConfig sysConfig){
		sysConfigDao.updateSysConfig(sysConfig);
		SysConfigMapper.setValue(sysConfig.getPcode(), sysConfig.getPvalue());
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteSysConfigById(String id){
		sysConfigDao.deleteSysConfigById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public SysConfig getSysConfigById(String id){
		return sysConfigDao.getSysConfigById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findSysConfigListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(sysConfigDao.findSysConfigListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询系统参数
	 * @param param
	 * @return
	 */
	 @Override
	public List<SysConfig> findSysConfigList(Map<String, Object> param){
		return sysConfigDao.findSysConfigList(param);
	}
	
}