package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Strap;

@Mapper
public interface StrapMapper {

	/**
	* 添加 手牌
	*/
	void addStrap(Strap strap);
	
	/**
	* 修改 手牌
	*/
	void updateStrap(Strap strap);
	
	/**
	*根据ID删除记录
	*/
	void deleteStrapById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Strap getStrapById(String id);
	
	/**
	* 分页查询
	*/
	List<Strap> findStrapListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询手牌
	 * @param param
	 * @return
	 */
	List<Strap> findStrapList(@Param("param") Map<String, Object> param);	
}