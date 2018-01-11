package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.TechnicianShift;

/**
 * @ClassName: TechnicianShiftMapper
 * @Description: 技师班次映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TechnicianShiftMapper {

	/**
	 * @Title: addTechnicianShift
	 * @Description:添加技师班次
	 * @param technicianShift 实体
	 * @return Integer
	 */
	Integer addTechnicianShift(TechnicianShift technicianShift);
	
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
	 * @param pageBounds 分页信息
	 * @param technicianShift 实体
	 * @return List<TechnicianShift>
	 */
	List<TechnicianShift> queryTechnicianShiftForPage(PageBounds pageBounds, @Param("technicianShift") TechnicianShift technicianShift);
	 
	 /**
	  * @Title: queryTechnicianShiftByProperty
	  * @Description:根据属性查询技师班次
	  * @return List<TechnicianShift>
	  */
	 List<TechnicianShift> queryTechnicianShiftByProperty(@Param("technicianShift") Map<String, Object> map);
	 
	 
	 
}
