package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.model.dao.AuthorizationMapper;
import com.jing.settlement.service.AuthorizationService;
import com.jing.utils.PrimaryKey;

@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Resource
	private AuthorizationMapper authorizationMapper;

	/**
	* 添加 消费授权
	*/
	@Override
	public void addAuthorization(Authorization authorization){
		authorization.setAuthorizationId(PrimaryKey.getUUID());
		authorizationMapper.addAuthorization(authorization);
	}
	
	/**
	* 修改 消费授权
	*/
	@Override
	public void updateAuthorization(Authorization authorization){
		authorizationMapper.updateAuthorization(authorization);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteAuthorizationById(String id){
		authorizationMapper.deleteAuthorizationById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Authorization getAuthorizationById(String id){
		return authorizationMapper.getAuthorizationById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findAuthorizationListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(authorizationMapper.findAuthorizationListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费授权
	 * @param param
	 * @return
	 */
	 @Override
	public List<Authorization> findAuthorizationList(Map<String, Object> param){
		return authorizationMapper.findAuthorizationList(param);
	}
	
}