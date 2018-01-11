package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.SkillClass;

/**
 * @ClassName: SkillClassMapper
 * @Description: 轮班映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface SkillClassMapper {

	/**
	 * @Title: addSkillClass
	 * @Description:添加轮班
	 * @param skillClass 实体
	 * @return Integer
	 */
	Integer addSkillClass(SkillClass skillClass);
	
	/**
	 * @Title modifySkillClass
	 * @Description:修改轮班
	 * @param skillClass 实体
	 * @return Integer
	 */
	Integer modifySkillClass(SkillClass skillClass);
	
	/**
	 * @Title: dropSkillClassByClassId
	 * @Description:删除轮班
	 * @param classId 实体标识
	 * @return Integer
	 */
	Integer dropSkillClassByClassId(Integer classId);
	
	/**
	 * @Title: querySkillClassByClassId
	 * @Description:根据实体标识查询轮班
	 * @param classId 实体标识
	 * @return SkillClass
	 */
	SkillClass querySkillClassByClassId(Integer classId);
	 
	/**
	 * @Title: querySkillClassForPage
	 * @Description: 根据轮班属性与分页信息分页查询轮班信息
	 * @param pageBounds 分页信息
	 * @param skillClass 实体
	 * @return List<SkillClass>
	 */
	List<SkillClass> querySkillClassForPage(PageBounds pageBounds, @Param("skillClass") SkillClass skillClass);
	 
	 /**
	  * @Title: querySkillClassByProperty
	  * @Description:根据属性查询轮班
	  * @return List<SkillClass>
	  */
	 List<SkillClass> querySkillClassByProperty(@Param("skillClass") Map<String, Object> map);
	 
	 
	 
}
