package com.jing.clock.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.clock.model.entity.Technician;
import com.jing.clock.model.dao.TechnicianMapper;
import com.jing.clock.service.TechnicianService;

/**
 * @ClassName: Technician
 * @Description: 技师服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("technicianService")
@Transactional(readOnly=true)
public class  TechnicianServiceImpl implements TechnicianService {	
	private static final Logger logger = LoggerFactory.getLogger(TechnicianServiceImpl.class);
	
	@Autowired
    private TechnicianMapper technicianMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTechnician
	 * @Description:添加技师
	 * @param technician 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Technician addTechnician(Technician technician){
		technician.setShiftStatus(0);
		int ret = technicianMapper.addTechnician(technician);
		if(ret>0){
			return technician;
		}
		return null;
	}
	
	/**
	 * @Title modifyTechnician
	 * @Description:修改技师
	 * @param technician 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTechnician(Technician technician){
		return technicianMapper.modifyTechnician(technician);
	}
	
	/**
	 * @Title: dropTechnicianByTechnicianId
	 * @Description:删除技师
	 * @param technicianId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTechnicianByTechnicianId(Integer technicianId){
		return technicianMapper.dropTechnicianByTechnicianId(technicianId);
	}
	
	/**
	 * @Title: queryTechnicianByTechnicianId
	 * @Description:根据实体标识查询技师
	 * @param technicianId 实体标识
	 * @return Technician
	 */
	@Override
	public Technician queryTechnicianByTechnicianId(Integer technicianId){
		return technicianMapper.queryTechnicianByTechnicianId(technicianId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTechnicianForPage
	 * @Description: 根据技师属性与分页信息分页查询技师信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technician 实体
	 * @return List<Technician>
	 */
	@Override
	public Map<String, Object> queryTechnicianForPage(Integer pagenum, Integer pagesize, String sort, Technician technician){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Technician.class);
		List<Technician> entityList = technicianMapper.queryTechnicianForPage(pageBounds, technician);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Technician.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Technician> pagelist = (PageList<Technician>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTechnicianByProperty
	 * @Description:根据属性查询技师
	 * @return List<Technician>
	 */
	@Override
	public List<Technician> queryTechnicianByProperty(Map<String, Object> map){
		return technicianMapper.queryTechnicianByProperty(map);
	}


}
