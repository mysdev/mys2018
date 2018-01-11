package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.TechnicianShift;

/**
 * @ClassName: TechnicianShift
 * @Description: 技师班次服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TechnicianShiftService {

    /**
	 * @Title: addTechnicianShift
	 * @Description:添加技师班次
	 * @param technicianShift 实体
	 * @return Integer
	 */
	TechnicianShift addTechnicianShift(TechnicianShift technicianShift);
	
	/**
	 * @Title modifyTechnicianShift
	 * @Description:修改技师班次
	 * @param technicianShift 实体
	 * @return Integer
	 */
	Integer modifyTechnicianShift(TechnicianShift technicianShift);
	
	/**
	 * @Title: dropTechnicianShiftByShiftId
	 * @Description:删除技师班次
	 * @param shiftId 实体标识
	 * @return Integer
	 */
	Integer dropTechnicianShiftByShiftId(Integer shiftId);
	
	/**
	 * @Title: queryTechnicianShiftByShiftId
	 * @Description:根据实体标识查询技师班次
	 * @param shiftId 实体标识
	 * @return TechnicianShift
	 */
	TechnicianShift queryTechnicianShiftByShiftId(Integer shiftId);
	 
	/**
	 * @Title: queryTechnicianShiftForPage
	 * @Description: 根据技师班次属性与分页信息分页查询技师班次信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianShift 实体
	 * @return List<TechnicianShift>
	 */
	Map<String, Object> queryTechnicianShiftForPage(Integer pagenum, Integer pagesize, String sort, TechnicianShift technicianShift);
	 
	 /**
	 * @Title: queryTechnicianShiftByProperty
	 * @Description:根据属性查询技师班次
	 * @return List<TechnicianShift>
	 */
	 List<TechnicianShift> queryTechnicianShiftByProperty(Map<String, Object> map);	 
	 
}
