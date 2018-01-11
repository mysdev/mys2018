package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Strap;

/**
 * @ClassName: StrapMapper
 * @Description: 手牌映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface StrapMapper {

	/**
	 * @Title: addStrap
	 * @Description:添加手牌
	 * @param strap 实体
	 * @return Integer
	 */
	Integer addStrap(Strap strap);
	
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
	 * @param pageBounds 分页信息
	 * @param strap 实体
	 * @return List<Strap>
	 */
	List<Strap> queryStrapForPage(PageBounds pageBounds, @Param("strap") Strap strap);
	 
	 /**
	  * @Title: queryStrapByProperty
	  * @Description:根据属性查询手牌
	  * @return List<Strap>
	  */
	 List<Strap> queryStrapByProperty(@Param("strap") Map<String, Object> map);
	 
	 
	 
}
