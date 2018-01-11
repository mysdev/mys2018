package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Strap;

/**
 * @ClassName: Strap
 * @Description: 手牌服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface StrapService {

    /**
	 * @Title: addStrap
	 * @Description:添加手牌
	 * @param strap 实体
	 * @return Integer
	 */
	Strap addStrap(Strap strap);
	
	/**
	 * @Title modifyStrap
	 * @Description:修改手牌
	 * @param strap 实体
	 * @return Integer
	 */
	Integer modifyStrap(Strap strap);
	
	/**
	 * @Title: dropStrapByStrapId
	 * @Description:删除手牌
	 * @param strapId 实体标识
	 * @return Integer
	 */
	Integer dropStrapByStrapId(String strapId);
	
	/**
	 * @Title: queryStrapByStrapId
	 * @Description:根据实体标识查询手牌
	 * @param strapId 实体标识
	 * @return Strap
	 */
	Strap queryStrapByStrapId(String strapId);
	 
	/**
	 * @Title: queryStrapForPage
	 * @Description: 根据手牌属性与分页信息分页查询手牌信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param strap 实体
	 * @return List<Strap>
	 */
	Map<String, Object> queryStrapForPage(Integer pagenum, Integer pagesize, String sort, Strap strap);
	 
	 /**
	 * @Title: queryStrapByProperty
	 * @Description:根据属性查询手牌
	 * @return List<Strap>
	 */
	 List<Strap> queryStrapByProperty(Map<String, Object> map);	 
	 
}
