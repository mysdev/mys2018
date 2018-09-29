package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Packages;

@Mapper
public interface PackagesMapper {

	/**
	* 添加 消费套餐
	*/
	void addPackages(Packages packages);
	
	/**
	* 修改 消费套餐
	*/
	void updatePackages(Packages packages);
	
	/**
	*根据ID删除记录
	*/
	void deletePackagesById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Packages getPackagesById(String id);
	
	/**
	* 分页查询
	*/
	List<Packages> findPackagesListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询消费套餐
	 * @param param
	 * @return
	 */
	List<Packages> findPackagesList(@Param("param") Map<String, Object> param);	
}