package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.TechnicianSkill;
import com.jing.clock.service.bo.TechnicianSkillBo;

/**
 * @ClassName: TechnicianSkillMapper
 * @Description: 技师技能映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TechnicianSkillMapper {

	/**
	 * @Title: addTechnicianSkill
	 * @Description:添加技师技能
	 * @param technicianSkill 实体
	 * @return Integer
	 */
	Integer addTechnicianSkill(TechnicianSkill technicianSkill);
	
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
	 * @param pageBounds 分页信息
	 * @param technicianSkill 实体
	 * @return List<TechnicianSkill>
	 */
	List<TechnicianSkillBo> queryTechnicianSkillForPage(PageBounds pageBounds, @Param("technicianSkill") Map<String, Object> technicianSkill);
	 
	 /**
	  * @Title: queryTechnicianSkillByProperty
	  * @Description:根据属性查询技师技能
	  * @return List<TechnicianSkill>
	  */
	 List<TechnicianSkill> queryTechnicianSkillByProperty(@Param("technicianSkill") Map<String, Object> map);

	/** 
	* @Title: dropTechnicianSkillByTechnicianId 
	* @Description: 根据技师标识清除技能
	* @param technicianId  void    返回类型 
	* @throws 
	*/
	Integer dropTechnicianSkillByTechnicianId(Integer technicianId);

	/** 
	* @Title: queryTechnicianSkillByTechnicianId 
	* @Description: 根据技师标识查询技能
	* @param technicianId
	* @return  List<TechnicianSkillBo>    返回类型 
	* @throws 
	*/
	List<TechnicianSkillBo> queryTechnicianSkillByTechnicianId(Integer technicianId);
	 
	 
	 
}
