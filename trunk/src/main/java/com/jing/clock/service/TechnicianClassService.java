package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.TechnicianClass;

/**
 * @ClassName: TechnicianClass
 * @Description: 轮班详情服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TechnicianClassService {

    /**
	 * @Title: addTechnicianClass
	 * @Description:添加轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	TechnicianClass addTechnicianClass(TechnicianClass technicianClass);
	
	/**
	 * @Title modifyTechnicianClass
	 * @Description:修改轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	Integer modifyTechnicianClass(TechnicianClass technicianClass);
	
	/**
	 * @Title: dropTechnicianClassByDetailId
	 * @Description:删除轮班详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	Integer dropTechnicianClassByDetailId(Integer detailId);
	
	/**
	 * @Title: queryTechnicianClassByDetailId
	 * @Description:根据实体标识查询轮班详情
	 * @param detailId 实体标识
	 * @return TechnicianClass
	 */
	TechnicianClass queryTechnicianClassByDetailId(Integer detailId);
	 
	/**
	 * @Title: queryTechnicianClassForPage
	 * @Description: 根据轮班详情属性与分页信息分页查询轮班详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianClass 实体
	 * @return List<TechnicianClass>
	 */
	Map<String, Object> queryTechnicianClassForPage(Integer pagenum, Integer pagesize, String sort, TechnicianClass technicianClass);
	 
	 /**
	 * @Title: queryTechnicianClassByProperty
	 * @Description:根据属性查询轮班详情
	 * @return List<TechnicianClass>
	 */
	 List<TechnicianClass> queryTechnicianClassByProperty(Map<String, Object> map);	 
	 
}
