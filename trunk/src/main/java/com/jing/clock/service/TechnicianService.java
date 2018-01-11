package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.Technician;

/**
 * @ClassName: Technician
 * @Description: 技师服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TechnicianService {

    /**
	 * @Title: addTechnician
	 * @Description:添加技师
	 * @param technician 实体
	 * @return Integer
	 */
	Technician addTechnician(Technician technician);
	
	/**
	 * @Title modifyTechnician
	 * @Description:修改技师
	 * @param technician 实体
	 * @return Integer
	 */
	Integer modifyTechnician(Technician technician);
	
	/**
	 * @Title: dropTechnicianByTechnicianId
	 * @Description:删除技师
	 * @param technicianId 实体标识
	 * @return Integer
	 */
	Integer dropTechnicianByTechnicianId(Integer technicianId);
	
	/**
	 * @Title: queryTechnicianByTechnicianId
	 * @Description:根据实体标识查询技师
	 * @param technicianId 实体标识
	 * @return Technician
	 */
	Technician queryTechnicianByTechnicianId(Integer technicianId);
	 
	/**
	 * @Title: queryTechnicianForPage
	 * @Description: 根据技师属性与分页信息分页查询技师信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technician 实体
	 * @return List<Technician>
	 */
	Map<String, Object> queryTechnicianForPage(Integer pagenum, Integer pagesize, String sort, Technician technician);
	 
	 /**
	 * @Title: queryTechnicianByProperty
	 * @Description:根据属性查询技师
	 * @return List<Technician>
	 */
	 List<Technician> queryTechnicianByProperty(Map<String, Object> map);	 
	 
}
