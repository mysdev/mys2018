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


import com.jing.clock.model.entity.TechnicianClass;
import com.jing.clock.model.dao.TechnicianClassMapper;
import com.jing.clock.service.TechnicianClassService;

/**
 * @ClassName: TechnicianClass
 * @Description: 轮班详情服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("technicianClassService")
@Transactional(readOnly=true)
public class  TechnicianClassServiceImpl implements TechnicianClassService {	
	private static final Logger logger = LoggerFactory.getLogger(TechnicianClassServiceImpl.class);
	
	@Autowired
    private TechnicianClassMapper technicianClassMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTechnicianClass
	 * @Description:添加轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TechnicianClass addTechnicianClass(TechnicianClass technicianClass){
		int ret = technicianClassMapper.addTechnicianClass(technicianClass);
		if(ret>0){
			return technicianClass;
		}
		return null;
	}
	
	/**
	 * @Title modifyTechnicianClass
	 * @Description:修改轮班详情
	 * @param technicianClass 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTechnicianClass(TechnicianClass technicianClass){
		return technicianClassMapper.modifyTechnicianClass(technicianClass);
	}
	
	/**
	 * @Title: dropTechnicianClassByDetailId
	 * @Description:删除轮班详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTechnicianClassByDetailId(Integer detailId){
		return technicianClassMapper.dropTechnicianClassByDetailId(detailId);
	}
	
	/**
	 * @Title: queryTechnicianClassByDetailId
	 * @Description:根据实体标识查询轮班详情
	 * @param detailId 实体标识
	 * @return TechnicianClass
	 */
	@Override
	public TechnicianClass queryTechnicianClassByDetailId(Integer detailId){
		return technicianClassMapper.queryTechnicianClassByDetailId(detailId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTechnicianClassForPage
	 * @Description: 根据轮班详情属性与分页信息分页查询轮班详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianClass 实体
	 * @return List<TechnicianClass>
	 */
	@Override
	public Map<String, Object> queryTechnicianClassForPage(Integer pagenum, Integer pagesize, String sort, TechnicianClass technicianClass){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TechnicianClass.class);
		List<TechnicianClass> entityList = technicianClassMapper.queryTechnicianClassForPage(pageBounds, technicianClass);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TechnicianClass.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TechnicianClass> pagelist = (PageList<TechnicianClass>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTechnicianClassByProperty
	 * @Description:根据属性查询轮班详情
	 * @return List<TechnicianClass>
	 */
	@Override
	public List<TechnicianClass> queryTechnicianClassByProperty(Map<String, Object> map){
		return technicianClassMapper.queryTechnicianClassByProperty(map);
	}


}
