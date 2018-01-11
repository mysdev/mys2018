package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.Authorization;

/**
 * @ClassName: AuthorizationMapper
 * @Description: 消费授权映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface AuthorizationMapper {

	/**
	 * @Title: addAuthorization
	 * @Description:添加消费授权
	 * @param authorization 实体
	 * @return Integer
	 */
	Integer addAuthorization(Authorization authorization);
	
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
	 * @param pageBounds 分页信息
	 * @param authorization 实体
	 * @return List<Authorization>
	 */
	List<Authorization> queryAuthorizationForPage(PageBounds pageBounds, @Param("authorization") Authorization authorization);
	 
	 /**
	  * @Title: queryAuthorizationByProperty
	  * @Description:根据属性查询消费授权
	  * @return List<Authorization>
	  */
	 List<Authorization> queryAuthorizationByProperty(@Param("authorization") Map<String, Object> map);
	 
	 
	 
}
