package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.Technician;

/**
 * @ClassName: TechnicianMapper
 * @Description: 技师映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TechnicianMapper {

	/**
	 * @Title: addTechnician
	 * @Description:添加技师
	 * @param technician 实体
	 * @return Integer
	 */
	Integer addTechnician(Technician technician);
	
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
	 * @param pageBounds 分页信息
	 * @param technician 实体
	 * @return List<Technician>
	 */
	List<Technician> queryTechnicianForPage(PageBounds pageBounds, @Param("technician") Technician technician);
	 
	 /**
	  * @Title: queryTechnicianByProperty
	  * @Description:根据属性查询技师
	  * @return List<Technician>
	  */
	 List<Technician> queryTechnicianByProperty(@Param("technician") Map<String, Object> map);
	 
	 
	 
}
