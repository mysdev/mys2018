package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.StrapMapper;
import com.jing.core.model.entity.Strap;
import com.jing.core.service.StrapService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Strap
 * @Description: 手牌服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("strapService")
@Transactional(readOnly=true)
public class  StrapServiceImpl implements StrapService {	
//	private static final Logger logger = LoggerFactory.getLogger(StrapServiceImpl.class);
	
	@Autowired
    private StrapMapper strapMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addStrap
	 * @Description:添加手牌
	 * @param strap 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Strap addStrap(Strap strap){
		strap.setStrapId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = strapMapper.addStrap(strap);
		if(ret>0){
			return strap;
		}
		return null;
	}
	
	/**
	 * @Title modifyStrap
	 * @Description:修改手牌
	 * @param strap 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyStrap(Strap strap){
		return strapMapper.modifyStrap(strap);
	}
	
	/**
	 * @Title: dropStrapByStrapId
	 * @Description:删除手牌
	 * @param strapId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropStrapByStrapId(String strapId){
		return strapMapper.dropStrapByStrapId(strapId);
	}
	
	/**
	 * @Title: queryStrapByStrapId
	 * @Description:根据实体标识查询手牌
	 * @param strapId 实体标识
	 * @return Strap
	 */
	@Override
	public Strap queryStrapByStrapId(String strapId){
		return strapMapper.queryStrapByStrapId(strapId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryStrapForPage
	 * @Description: 根据手牌属性与分页信息分页查询手牌信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param strap 实体
	 * @return List<Strap>
	 */
	@Override
	public Map<String, Object> queryStrapForPage(Integer pagenum, Integer pagesize, String sort, Strap strap){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Strap.class);
		List<Strap> entityList = strapMapper.queryStrapForPage(pageBounds, strap);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Strap.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Strap> pagelist = (PageList<Strap>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryStrapByProperty
	 * @Description:根据属性查询手牌
	 * @return List<Strap>
	 */
	@Override
	public List<Strap> queryStrapByProperty(Map<String, Object> map){
		return strapMapper.queryStrapByProperty(map);
	}


}
