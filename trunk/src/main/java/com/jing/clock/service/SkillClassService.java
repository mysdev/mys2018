package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.SkillClass;

/**
 * @ClassName: SkillClass
 * @Description: 轮班服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface SkillClassService {

    /**
	 * @Title: addSkillClass
	 * @Description:添加轮班
	 * @param skillClass 实体
	 * @return Integer
	 */
	SkillClass addSkillClass(SkillClass skillClass);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param skillClass 实体
	 * @return List<SkillClass>
	 */
	Map<String, Object> querySkillClassForPage(Integer pagenum, Integer pagesize, String sort, SkillClass skillClass);
	 
	 /**
	 * @Title: querySkillClassByProperty
	 * @Description:根据属性查询轮班
	 * @return List<SkillClass>
	 */
	 List<SkillClass> querySkillClassByProperty(Map<String, Object> map);	 
	 
}
