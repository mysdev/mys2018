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
import java.util.UUID;


import com.jing.settlement.model.entity.Goods;
import com.jing.settlement.model.dao.GoodsMapper;
import com.jing.settlement.service.GoodsService;

/**
 * @ClassName: Goods
 * @Description: 商品服务服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("goodsService")
@Transactional(readOnly=true)
public class  GoodsServiceImpl implements GoodsService {	
	private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
	
	@Autowired
    private GoodsMapper goodsMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addGoods
	 * @Description:添加商品服务
	 * @param goods 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Goods addGoods(Goods goods){
		goods.setGoodsId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = goodsMapper.addGoods(goods);
		if(ret>0){
			return goods;
		}
		return null;
	}
	
	/**
	 * @Title modifyGoods
	 * @Description:修改商品服务
	 * @param goods 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyGoods(Goods goods){
		return goodsMapper.modifyGoods(goods);
	}
	
	/**
	 * @Title: dropGoodsByGoodsId
	 * @Description:删除商品服务
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropGoodsByGoodsId(String goodsId){
		return goodsMapper.dropGoodsByGoodsId(goodsId);
	}
	
	/**
	 * @Title: queryGoodsByGoodsId
	 * @Description:根据实体标识查询商品服务
	 * @param goodsId 实体标识
	 * @return Goods
	 */
	@Override
	public Goods queryGoodsByGoodsId(String goodsId){
		return goodsMapper.queryGoodsByGoodsId(goodsId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryGoodsForPage
	 * @Description: 根据商品服务属性与分页信息分页查询商品服务信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goods 实体
	 * @return List<Goods>
	 */
	@Override
	public Map<String, Object> queryGoodsForPage(Integer pagenum, Integer pagesize, String sort, Goods goods){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Goods.class);
		List<Goods> entityList = goodsMapper.queryGoodsForPage(pageBounds, goods);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Goods.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Goods> pagelist = (PageList<Goods>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryGoodsByProperty
	 * @Description:根据属性查询商品服务
	 * @return List<Goods>
	 */
	@Override
	public List<Goods> queryGoodsByProperty(Map<String, Object> map){
		return goodsMapper.queryGoodsByProperty(map);
	}


}
