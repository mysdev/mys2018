package com.jing.settlement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.settlement.model.dao.AuthorizationMapper;
import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.service.AuthorizationService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Authorization
 * @Description: 消费授权服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("authorizationService")
@Transactional(readOnly=true)
public class  AuthorizationServiceImpl implements AuthorizationService {	
//	private static final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	@Autowired
    private AuthorizationMapper authorizationMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAuthorization
	 * @Description:添加消费授权
	 * @param authorization 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Authorization addAuthorization(Authorization authorization){
		authorization.setAuthorizationId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = authorizationMapper.addAuthorization(authorization);
		if(ret>0){
			return authorization;
		}
		return null;
	}
	
	/**
	 * @Title modifyAuthorization
	 * @Description:修改消费授权
	 * @param authorization 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAuthorization(Authorization authorization){
		return authorizationMapper.modifyAuthorization(authorization);
	}
	
	/**
	 * @Title: dropAuthorizationByAuthorizationId
	 * @Description:删除消费授权
	 * @param authorizationId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAuthorizationByAuthorizationId(String authorizationId){
		return authorizationMapper.dropAuthorizationByAuthorizationId(authorizationId);
	}
	
	/**
	 * @Title: queryAuthorizationByAuthorizationId
	 * @Description:根据实体标识查询消费授权
	 * @param authorizationId 实体标识
	 * @return Authorization
	 */
	@Override
	public Authorization queryAuthorizationByAuthorizationId(String authorizationId){
		return authorizationMapper.queryAuthorizationByAuthorizationId(authorizationId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAuthorizationForPage
	 * @Description: 根据消费授权属性与分页信息分页查询消费授权信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param authorization 实体
	 * @return List<Authorization>
	 */
	@Override
	public Map<String, Object> queryAuthorizationForPage(Integer pagenum, Integer pagesize, String sort, Authorization authorization){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Authorization.class);
		List<Authorization> entityList = authorizationMapper.queryAuthorizationForPage(pageBounds, authorization);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Authorization.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Authorization> pagelist = (PageList<Authorization>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAuthorizationByProperty
	 * @Description:根据属性查询消费授权
	 * @return List<Authorization>
	 */
	@Override
	public List<Authorization> queryAuthorizationByProperty(Map<String, Object> map){
		return authorizationMapper.queryAuthorizationByProperty(map);
	}


}
