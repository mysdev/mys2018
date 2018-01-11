package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.TechnicianSkill;

/**
 * @ClassName: TechnicianSkill
 * @Description: 技师技能服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TechnicianSkillService {

    /**
	 * @Title: addTechnicianSkill
	 * @Description:添加技师技能
	 * @param technicianSkill 实体
	 * @return Integer
	 */
	TechnicianSkill addTechnicianSkill(TechnicianSkill technicianSkill);
	
	/**
	 * @Title modifyTechnicianSkill
	 * @Description:修改技师技能
	 * @param technicianSkill 实体
	 * @return Integer
	 */
	Integer modifyTechnicianSkill(TechnicianSkill technicianSkill);
	
	/**
	 * @Title: dropTechnicianSkillByTsId
	 * @Description:删除技师技能
	 * @param tsId 实体标识
	 * @return Integer
	 */
	Integer dropTechnicianSkillByTsId(Integer tsId);
	
	/**
	 * @Title: queryTechnicianSkillByTsId
	 * @Description:根据实体标识查询技师技能
	 * @param tsId 实体标识
	 * @return TechnicianSkill
	 */
	TechnicianSkill queryTechnicianSkillByTsId(Integer tsId);
	 
	/**
	 * @Title: queryTechnicianSkillForPage
	 * @Description: 根据技师技能属性与分页信息分页查询技师技能信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianSkill 实体
	 * @return List<TechnicianSkill>
	 */
	Map<String, Object> queryTechnicianSkillForPage(Integer pagenum, Integer pagesize, String sort, TechnicianSkill technicianSkill);
	 
	 /**
	 * @Title: queryTechnicianSkillByProperty
	 * @Description:根据属性查询技师技能
	 * @return List<TechnicianSkill>
	 */
	 List<TechnicianSkill> queryTechnicianSkillByProperty(Map<String, Object> map);	 
	 
}
