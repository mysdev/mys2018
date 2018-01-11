package com.jing.settlement.service.impl;

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


import com.jing.settlement.model.entity.GoodsMaterial;
import com.jing.settlement.model.dao.GoodsMaterialMapper;
import com.jing.settlement.service.GoodsMaterialService;

/**
 * @ClassName: GoodsMaterial
 * @Description: 基本原料服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("goodsMaterialService")
@Transactional(readOnly=true)
public class  GoodsMaterialServiceImpl implements GoodsMaterialService {	
	private static final Logger logger = LoggerFactory.getLogger(GoodsMaterialServiceImpl.class);
	
	@Autowired
    private GoodsMaterialMapper goodsMaterialMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addGoodsMaterial
	 * @Description:添加基本原料
	 * @param goodsMaterial 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public GoodsMaterial addGoodsMaterial(GoodsMaterial goodsMaterial){
		int ret = goodsMaterialMapper.addGoodsMaterial(goodsMaterial);
		if(ret>0){
			return goodsMaterial;
		}
		return null;
	}
	
	/**
	 * @Title modifyGoodsMaterial
	 * @Description:修改基本原料
	 * @param goodsMaterial 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyGoodsMaterial(GoodsMaterial goodsMaterial){
		return goodsMaterialMapper.modifyGoodsMaterial(goodsMaterial);
	}
	
	/**
	 * @Title: dropGoodsMaterialByMaterialId
	 * @Description:删除基本原料
	 * @param materialId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropGoodsMaterialByMaterialId(Integer materialId){
		return goodsMaterialMapper.dropGoodsMaterialByMaterialId(materialId);
	}
	
	/**
	 * @Title: queryGoodsMaterialByMaterialId
	 * @Description:根据实体标识查询基本原料
	 * @param materialId 实体标识
	 * @return GoodsMaterial
	 */
	@Override
	public GoodsMaterial queryGoodsMaterialByMaterialId(Integer materialId){
		return goodsMaterialMapper.queryGoodsMaterialByMaterialId(materialId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryGoodsMaterialForPage
	 * @Description: 根据基本原料属性与分页信息分页查询基本原料信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsMaterial 实体
	 * @return List<GoodsMaterial>
	 */
	@Override
	public Map<String, Object> queryGoodsMaterialForPage(Integer pagenum, Integer pagesize, String sort, GoodsMaterial goodsMaterial){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, GoodsMaterial.class);
		List<GoodsMaterial> entityList = goodsMaterialMapper.queryGoodsMaterialForPage(pageBounds, goodsMaterial);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, GoodsMaterial.class);
		}
		if (!entityList.isEmpty()) {
			PageList<GoodsMaterial> pagelist = (PageList<GoodsMaterial>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryGoodsMaterialByProperty
	 * @Description:根据属性查询基本原料
	 * @return List<GoodsMaterial>
	 */
	@Override
	public List<GoodsMaterial> queryGoodsMaterialByProperty(Map<String, Object> map){
		return goodsMaterialMapper.queryGoodsMaterialByProperty(map);
	}


}
