package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.Goods;
import com.jing.settlement.model.dao.GoodsMapper;
import com.jing.settlement.service.GoodsService;
import com.jing.utils.PrimaryKey;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private GoodsMapper goodsMapper;

	/**
	* 添加 商品服务
	*/
	@Override
	public void addGoods(Goods goods){
		goods.setGoodsId(PrimaryKey.getUUID());
		goodsMapper.addGoods(goods);
	}
	
	/**
	* 修改 商品服务
	*/
	@Override
	public void updateGoods(Goods goods){
		goodsMapper.updateGoods(goods);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteGoodsById(String id){
		goodsMapper.deleteGoodsById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Goods getGoodsById(String id){
		return goodsMapper.getGoodsById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findGoodsListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(goodsMapper.findGoodsListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询商品服务
	 * @param param
	 * @return
	 */
	 @Override
	public List<Goods> findGoodsList(Map<String, Object> param){
		return goodsMapper.findGoodsList(param);
	}
	
}