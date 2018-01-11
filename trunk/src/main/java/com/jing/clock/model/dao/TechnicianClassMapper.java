package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.TechnicianClass;

/**
 * @ClassName: TechnicianClassMapper
 * @Description: 轮班详情映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TechnicianClassMapper {

	/**
	 * @Title: addTechnicianClass
	 * @Description:添加轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	Integer addTechnicianClass(TechnicianClass technicianClass);
	
	/**
	 * @Title modifyTechnicianClass
	 * @Description:修改轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	Integer modifyTechnicianClass(TechnicianClass technicianClass);
	
	/**
	 * @Title: dropTechnicianClassByDetailId
	 * @Description:删除轮班详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	Integer dropTechnicianClassByDetailId(Integer detailId);
	
	/**
	 * @Title: queryTechnicianClassByDetailId
	 * @Description:根据实体标识查询轮班详情
	 * @param detailId 实体标识
	 * @return TechnicianClass
	 */
	TechnicianClass queryTechnicianClassByDetailId(Integer detailId);
	 
	/**
	 * @Title: queryTechnicianClassForPage
	 * @Description: 根据轮班详情属性与分页信息分页查询轮班详情信息
	 * @param pageBounds 分页信息
	 * @param technicianClass 实体
	 * @return List<TechnicianClass>
	 */
	List<TechnicianClass> queryTechnicianClassForPage(PageBounds pageBounds, @Param("technicianClass") TechnicianClass technicianClass);
	 
	 /**
	  * @Title: queryTechnicianClassByProperty
	  * @Description:根据属性查询轮班详情
	  * @return List<TechnicianClass>
	  */
	 List<TechnicianClass> queryTechnicianClassByProperty(@Param("technicianClass") Map<String, Object> map);
	 
	 
	 
}
