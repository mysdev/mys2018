package com.jing.settlement.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Authorization;

public interface AuthorizationService {

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
	PageInfo findAuthorizationListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询消费授权
	 * @param param
	 * @return
	 */
	List<Authorization> findAuthorizationList(Map<String, Object> param);
}