package com.jing.clock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.clock.model.dao.TechnicianShiftMapper;
import com.jing.clock.model.entity.TechnicianShift;
import com.jing.clock.service.TechnicianShiftService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: TechnicianShift
 * @Description: 技师班次服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("technicianShiftService")
@Transactional(readOnly=true)
public class  TechnicianShiftServiceImpl implements TechnicianShiftService {	
//	private static final Logger logger = LoggerFactory.getLogger(TechnicianShiftServiceImpl.class);
	
	@Autowired
    private TechnicianShiftMapper technicianShiftMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTechnicianShift
	 * @Description:添加技师班次
	 * @param technicianShift 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TechnicianShift addTechnicianShift(TechnicianShift technicianShift){
		int ret = technicianShiftMapper.addTechnicianShift(technicianShift);
		if(ret>0){
			return technicianShift;
		}
		return null;
	}
	
	/**
	 * @Title modifyTechnicianShift
	 * @Description:修改技师班次
	 * @param technicianShift 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTechnicianShift(TechnicianShift technicianShift){
		return technicianShiftMapper.modifyTechnicianShift(technicianShift);
	}
	
	/**
	 * @Title: dropTechnicianShiftByShiftId
	 * @Description:删除技师班次
	 * @param shiftId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTechnicianShiftByShiftId(Integer shiftId){
		return technicianShiftMapper.dropTechnicianShiftByShiftId(shiftId);
	}
	
	/**
	 * @Title: queryTechnicianShiftByShiftId
	 * @Description:根据实体标识查询技师班次
	 * @param shiftId 实体标识
	 * @return TechnicianShift
	 */
	@Override
	public TechnicianShift queryTechnicianShiftByShiftId(Integer shiftId){
		return technicianShiftMapper.queryTechnicianShiftByShiftId(shiftId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTechnicianShiftForPage
	 * @Description: 根据技师班次属性与分页信息分页查询技师班次信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param technicianShift 实体
	 * @return List<TechnicianShift>
	 */
	@Override
	public Map<String, Object> queryTechnicianShiftForPage(Integer pagenum, Integer pagesize, String sort, TechnicianShift technicianShift){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TechnicianShift.class);
		List<TechnicianShift> entityList = technicianShiftMapper.queryTechnicianShiftForPage(pageBounds, technicianShift);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TechnicianShift.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TechnicianShift> pagelist = (PageList<TechnicianShift>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTechnicianShiftByProperty
	 * @Description:根据属性查询技师班次
	 * @return List<TechnicianShift>
	 */
	@Override
	public List<TechnicianShift> queryTechnicianShiftByProperty(Map<String, Object> map){
		return technicianShiftMapper.queryTechnicianShiftByProperty(map);
	}


}
