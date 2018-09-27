package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.model.dao.PackagesMapper;
import com.jing.settlement.service.PackagesService;
import com.jing.utils.PrimaryKey;

@Service("packagesService")
public class PackagesServiceImpl implements PackagesService{

	@Resource
	private PackagesMapper packagesMapper;

	/**
	* 添加 消费套餐
	*/
	@Override
	public void addPackages(Packages packages){
		packages.setPackageId(PrimaryKey.getUUID());
		packagesMapper.addPackages(packages);
	}
	
	/**
	* 修改 消费套餐
	*/
	@Override
	public void updatePackages(Packages packages){
		packagesMapper.updatePackages(packages);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deletePackagesById(String id){
		packagesMapper.deletePackagesById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Packages getPackagesById(String id){
		return packagesMapper.getPackagesById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findPackagesListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(packagesMapper.findPackagesListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费套餐
	 * @param param
	 * @return
	 */
	 @Override
	public List<Packages> findPackagesList(Map<String, Object> param){
		return packagesMapper.findPackagesList(param);
	}
	
}