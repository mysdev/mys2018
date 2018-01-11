package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.ClockSkill;

/**
 * @ClassName: ClockSkill
 * @Description: 技能服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ClockSkillService {

    /**
	 * @Title: addClockSkill
	 * @Description:添加技能
	 * @param clockSkill 实体
	 * @return Integer
	 */
	ClockSkill addClockSkill(ClockSkill clockSkill);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockSkill 实体
	 * @return List<ClockSkill>
	 */
	Map<String, Object> queryClockSkillForPage(Integer pagenum, Integer pagesize, String sort, ClockSkill clockSkill);
	 
	 /**
	 * @Title: queryClockSkillByProperty
	 * @Description:根据属性查询技能
	 * @return List<ClockSkill>
	 */
	 List<ClockSkill> queryClockSkillByProperty(Map<String, Object> map);	 
	 
}
