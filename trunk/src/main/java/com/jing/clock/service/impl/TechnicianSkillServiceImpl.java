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


import com.jing.clock.model.entity.TechnicianSkill;
import com.jing.clock.model.dao.TechnicianSkillMapper;
import com.jing.clock.service.TechnicianSkillService;

/**
 * @ClassName: TechnicianSkill
 * @Description: 技师技能服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("technicianSkillService")
@Transactional(readOnly=true)
public class  TechnicianSkillServiceImpl implements TechnicianSkillService {	
	private static final Logger logger = LoggerFactory.getLogger(TechnicianSkillServiceImpl.class);
	
	@Autowired
    private TechnicianSkillMapper technicianSkillMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTechnicianSkill
	 * @Description:添加技师技能
	 * @param technicianSkill 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TechnicianSkill addTechnicianSkill(TechnicianSkill technicianSkill){
		int ret = technicianSkillMapper.addTechnicianSkill(technicianSkill);
		if(ret>0){
			return technicianSkill;
		}
		return null;
	}
	
	/**
	 * @Title modifyTechnicianSkill
	 * @Description:修改技师技能
	 * @param technicianSkill 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTechnicianSkill(TechnicianSkill technicianSkill){
		return technicianSkillMapper.modifyTechnicianSkill(technicianSkill);
	}
	
	/**
	 * @Title: dropTechnicianSkillByTsId
	 * @Description:删除技师技能
	 * @param tsId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTechnicianSkillByTsId(Integer tsId){
		return technicianSkillMapper.dropTechnicianSkillByTsId(tsId);
	}
	
	/**
	 * @Title: queryTechnicianSkillByTsId
	 * @Description:根据实体标识查询技师技能
	 * @param tsId 实体标识
	 * @return TechnicianSkill
	 */
	@Override
	public TechnicianSkill queryTechnicianSkillByTsId(Integer tsId){
		return technicianSkillMapper.queryTechnicianSkillByTsId(tsId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTechnicianSkillForPage
	 * @Description: 根据技师技能属性与分页信息分页查询技师技能信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianSkill 实体
	 * @return List<TechnicianSkill>
	 */
	@Override
	public Map<String, Object> queryTechnicianSkillForPage(Integer pagenum, Integer pagesize, String sort, TechnicianSkill technicianSkill){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TechnicianSkill.class);
		List<TechnicianSkill> entityList = technicianSkillMapper.queryTechnicianSkillForPage(pageBounds, technicianSkill);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TechnicianSkill.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TechnicianSkill> pagelist = (PageList<TechnicianSkill>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTechnicianSkillByProperty
	 * @Description:根据属性查询技师技能
	 * @return List<TechnicianSkill>
	 */
	@Override
	public List<TechnicianSkill> queryTechnicianSkillByProperty(Map<String, Object> map){
		return technicianSkillMapper.queryTechnicianSkillByProperty(map);
	}


}
