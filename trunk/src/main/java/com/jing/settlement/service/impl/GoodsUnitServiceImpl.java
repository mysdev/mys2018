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


import com.jing.settlement.model.entity.GoodsUnit;
import com.jing.settlement.model.dao.GoodsUnitMapper;
import com.jing.settlement.service.GoodsUnitService;

/**
 * @ClassName: GoodsUnit
 * @Description: 商品单位服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("goodsUnitService")
@Transactional(readOnly=true)
public class  GoodsUnitServiceImpl implements GoodsUnitService {	
	private static final Logger logger = LoggerFactory.getLogger(GoodsUnitServiceImpl.class);
	
	@Autowired
    private GoodsUnitMapper goodsUnitMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addGoodsUnit
	 * @Description:添加商品单位
	 * @param goodsUnit 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public GoodsUnit addGoodsUnit(GoodsUnit goodsUnit){
		int ret = goodsUnitMapper.addGoodsUnit(goodsUnit);
		if(ret>0){
			return goodsUnit;
		}
		return null;
	}
	
	/**
	 * @Title modifyGoodsUnit
	 * @Description:修改商品单位
	 * @param goodsUnit 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyGoodsUnit(GoodsUnit goodsUnit){
		return goodsUnitMapper.modifyGoodsUnit(goodsUnit);
	}
	
	/**
	 * @Title: dropGoodsUnitByUnitId
	 * @Description:删除商品单位
	 * @param unitId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropGoodsUnitByUnitId(Integer unitId){
		return goodsUnitMapper.dropGoodsUnitByUnitId(unitId);
	}
	
	/**
	 * @Title: queryGoodsUnitByUnitId
	 * @Description:根据实体标识查询商品单位
	 * @param unitId 实体标识
	 * @return GoodsUnit
	 */
	@Override
	public GoodsUnit queryGoodsUnitByUnitId(Integer unitId){
		return goodsUnitMapper.queryGoodsUnitByUnitId(unitId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryGoodsUnitForPage
	 * @Description: 根据商品单位属性与分页信息分页查询商品单位信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsUnit 实体
	 * @return List<GoodsUnit>
	 */
	@Override
	public Map<String, Object> queryGoodsUnitForPage(Integer pagenum, Integer pagesize, String sort, GoodsUnit goodsUnit){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, GoodsUnit.class);
		List<GoodsUnit> entityList = goodsUnitMapper.queryGoodsUnitForPage(pageBounds, goodsUnit);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, GoodsUnit.class);
		}
		if (!entityList.isEmpty()) {
			PageList<GoodsUnit> pagelist = (PageList<GoodsUnit>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryGoodsUnitByProperty
	 * @Description:根据属性查询商品单位
	 * @return List<GoodsUnit>
	 */
	@Override
	public List<GoodsUnit> queryGoodsUnitByProperty(Map<String, Object> map){
		return goodsUnitMapper.queryGoodsUnitByProperty(map);
	}


}
