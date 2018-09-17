package com.jing.clock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.clock.model.dao.SkillClassMapper;
import com.jing.clock.model.entity.SkillClass;
import com.jing.clock.service.SkillClassService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: SkillClass
 * @Description: 轮班服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("skillClassService")
@Transactional(readOnly=true)
public class  SkillClassServiceImpl implements SkillClassService {	
//	private static final Logger logger = LoggerFactory.getLogger(SkillClassServiceImpl.class);
	
	@Autowired
    private SkillClassMapper skillClassMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addSkillClass
	 * @Description:添加轮班
	 * @param skillClass 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public SkillClass addSkillClass(SkillClass skillClass){
		int ret = skillClassMapper.addSkillClass(skillClass);
		if(ret>0){
			return skillClass;
		}
		return null;
	}
	
	/**
	 * @Title modifySkillClass
	 * @Description:修改轮班
	 * @param skillClass 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifySkillClass(SkillClass skillClass){
		return skillClassMapper.modifySkillClass(skillClass);
	}
	
	/**
	 * @Title: dropSkillClassByClassId
	 * @Description:删除轮班
	 * @param classId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropSkillClassByClassId(Integer classId){
		return skillClassMapper.dropSkillClassByClassId(classId);
	}
	
	/**
	 * @Title: querySkillClassByClassId
	 * @Description:根据实体标识查询轮班
	 * @param classId 实体标识
	 * @return SkillClass
	 */
	@Override
	public SkillClass querySkillClassByClassId(Integer classId){
		return skillClassMapper.querySkillClassByClassId(classId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: querySkillClassForPage
	 * @Description: 根据轮班属性与分页信息分页查询轮班信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param skillClass 实体
	 * @return List<SkillClass>
	 */
	@Override
	public Map<String, Object> querySkillClassForPage(Integer pagenum, Integer pagesize, String sort, SkillClass skillClass){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, SkillClass.class);
		List<SkillClass> entityList = skillClassMapper.querySkillClassForPage(pageBounds, skillClass);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, SkillClass.class);
		}
		if (!entityList.isEmpty()) {
			PageList<SkillClass> pagelist = (PageList<SkillClass>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: querySkillClassByProperty
	 * @Description:根据属性查询轮班
	 * @return List<SkillClass>
	 */
	@Override
	public List<SkillClass> querySkillClassByProperty(Map<String, Object> map){
		return skillClassMapper.querySkillClassByProperty(map);
	}


}
