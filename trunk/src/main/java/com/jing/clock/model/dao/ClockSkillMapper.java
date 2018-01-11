package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.ClockSkill;

/**
 * @ClassName: ClockSkillMapper
 * @Description: 技能映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ClockSkillMapper {

	/**
	 * @Title: addClockSkill
	 * @Description:添加技能
	 * @param clockSkill 实体
	 * @return Integer
	 */
	Integer addClockSkill(ClockSkill clockSkill);
	
	/**
	 * @Title modifyClockSkill
	 * @Description:修改技能
	 * @param clockSkill 实体
	 * @return Integer
	 */
	Integer modifyClockSkill(ClockSkill clockSkill);
	
	/**
	 * @Title: dropClockSkillBySkillId
	 * @Description:删除技能
	 * @param skillId 实体标识
	 * @return Integer
	 */
	Integer dropClockSkillBySkillId(Integer skillId);
	
	/**
	 * @Title: queryClockSkillBySkillId
	 * @Description:根据实体标识查询技能
	 * @param skillId 实体标识
	 * @return ClockSkill
	 */
	ClockSkill queryClockSkillBySkillId(Integer skillId);
	 
	/**
	 * @Title: queryClockSkillForPage
	 * @Description: 根据技能属性与分页信息分页查询技能信息
	 * @param pageBounds 分页信息
	 * @param clockSkill 实体
	 * @return List<ClockSkill>
	 */
	List<ClockSkill> queryClockSkillForPage(PageBounds pageBounds, @Param("clockSkill") ClockSkill clockSkill);
	 
	 /**
	  * @Title: queryClockSkillByProperty
	  * @Description:根据属性查询技能
	  * @return List<ClockSkill>
	  */
	 List<ClockSkill> queryClockSkillByProperty(@Param("clockSkill") Map<String, Object> map);
	 
	 
	 
}
