package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Authorization;

@Mapper
public interface AuthorizationMapper {

	/**
	* 添加 消费授权
	*/
	void addAuthorization(Authorization authorization);
	
	/**
	* 修改 消费授权
	*/
	void updateAuthorization(Authorization authorization);
	
	/**
	*根据ID删除记录
	*/
	void deleteAuthorizationById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Authorization getAuthorizationById(String id);
	
	/**
	* 分页查询
	*/
	List<Authorization> findAuthorizationListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询消费授权
	 * @param param
	 * @return
	 */
	List<Authorization> findAuthorizationList(@Param("param") Map<String, Object> param);	
}