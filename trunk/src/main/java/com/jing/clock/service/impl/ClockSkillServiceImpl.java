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


import com.jing.clock.model.entity.ClockSkill;
import com.jing.clock.model.dao.ClockSkillMapper;
import com.jing.clock.service.ClockSkillService;

/**
 * @ClassName: ClockSkill
 * @Description: 技能服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("clockSkillService")
@Transactional(readOnly=true)
public class  ClockSkillServiceImpl implements ClockSkillService {	
	private static final Logger logger = LoggerFactory.getLogger(ClockSkillServiceImpl.class);
	
	@Autowired
    private ClockSkillMapper clockSkillMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addClockSkill
	 * @Description:添加技能
	 * @param clockSkill 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ClockSkill addClockSkill(ClockSkill clockSkill){
		int ret = clockSkillMapper.addClockSkill(clockSkill);
		if(ret>0){
			return clockSkill;
		}
		return null;
	}
	
	/**
	 * @Title modifyClockSkill
	 * @Description:修改技能
	 * @param clockSkill 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyClockSkill(ClockSkill clockSkill){
		return clockSkillMapper.modifyClockSkill(clockSkill);
	}
	
	/**
	 * @Title: dropClockSkillBySkillId
	 * @Description:删除技能
	 * @param skillId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropClockSkillBySkillId(Integer skillId){
		return clockSkillMapper.dropClockSkillBySkillId(skillId);
	}
	
	/**
	 * @Title: queryClockSkillBySkillId
	 * @Description:根据实体标识查询技能
	 * @param skillId 实体标识
	 * @return ClockSkill
	 */
	@Override
	public ClockSkill queryClockSkillBySkillId(Integer skillId){
		return clockSkillMapper.queryClockSkillBySkillId(skillId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryClockSkillForPage
	 * @Description: 根据技能属性与分页信息分页查询技能信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockSkill 实体
	 * @return List<ClockSkill>
	 */
	@Override
	public Map<String, Object> queryClockSkillForPage(Integer pagenum, Integer pagesize, String sort, ClockSkill clockSkill){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ClockSkill.class);
		List<ClockSkill> entityList = clockSkillMapper.queryClockSkillForPage(pageBounds, clockSkill);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ClockSkill.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ClockSkill> pagelist = (PageList<ClockSkill>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryClockSkillByProperty
	 * @Description:根据属性查询技能
	 * @return List<ClockSkill>
	 */
	@Override
	public List<ClockSkill> queryClockSkillByProperty(Map<String, Object> map){
		return clockSkillMapper.queryClockSkillByProperty(map);
	}


}
