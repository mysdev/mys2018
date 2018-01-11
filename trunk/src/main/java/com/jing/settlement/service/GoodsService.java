package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.Goods;

/**
 * @ClassName: Goods
 * @Description: 商品服务服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface GoodsService {

    /**
	 * @Title: addGoods
	 * @Description:添加商品服务
	 * @param goods 实体
	 * @return Integer
	 */
	Goods addGoods(Goods goods);
	
	/**
	 * @Title modifyGoods
	 * @Description:修改商品服务
	 * @param goods 实体
	 * @return Integer
	 */
	Integer modifyGoods(Goods goods);
	
	/**
	 * @Title: dropGoodsByGoodsId
	 * @Description:删除商品服务
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsByGoodsId(String goodsId);
	
	/**
	 * @Title: queryGoodsByGoodsId
	 * @Description:根据实体标识查询商品服务
	 * @param goodsId 实体标识
	 * @return Goods
	 */
	Goods queryGoodsByGoodsId(String goodsId);
	 
	/**
	 * @Title: queryGoodsForPage
	 * @Description: 根据商品服务属性与分页信息分页查询商品服务信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goods 实体
	 * @return List<Goods>
	 */
	Map<String, Object> queryGoodsForPage(Integer pagenum, Integer pagesize, String sort, Goods goods);
	 
	 /**
	 * @Title: queryGoodsByProperty
	 * @Description:根据属性查询商品服务
	 * @return List<Goods>
	 */
	 List<Goods> queryGoodsByProperty(Map<String, Object> map);	 
	 
}
