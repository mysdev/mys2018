package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.Authorization;

/**
 * @ClassName: Authorization
 * @Description: 消费授权服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface AuthorizationService {

    /**
	 * @Title: addAuthorization
	 * @Description:添加消费授权
	 * @param authorization 实体
	 * @return Integer
	 */
	Authorization addAuthorization(Authorization authorization);
	
	/**
	 * @Title modifyAuthorization
	 * @Description:修改消费授权
	 * @param authorization 实体
	 * @return Integer
	 */
	Integer modifyAuthorization(Authorization authorization);
	
	/**
	 * @Title: dropAuthorizationByAuthorizationId
	 * @Description:删除消费授权
	 * @param authorizationId 实体标识
	 * @return Integer
	 */
	Integer dropAuthorizationByAuthorizationId(String authorizationId);
	
	/**
	 * @Title: queryAuthorizationByAuthorizationId
	 * @Description:根据实体标识查询消费授权
	 * @param authorizationId 实体标识
	 * @return Authorization
	 */
	Authorization queryAuthorizationByAuthorizationId(String authorizationId);
	 
	/**
	 * @Title: queryAuthorizationForPage
	 * @Description: 根据消费授权属性与分页信息分页查询消费授权信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param authorization 实体
	 * @return List<Authorization>
	 */
	Map<String, Object> queryAuthorizationForPage(Integer pagenum, Integer pagesize, String sort, Authorization authorization);
	 
	 /**
	 * @Title: queryAuthorizationByProperty
	 * @Description:根据属性查询消费授权
	 * @return List<Authorization>
	 */
	 List<Authorization> queryAuthorizationByProperty(Map<String, Object> map);	 
	 
}
