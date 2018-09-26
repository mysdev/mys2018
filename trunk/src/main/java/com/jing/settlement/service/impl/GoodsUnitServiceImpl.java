package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.GoodsUnit;
import com.jing.settlement.model.dao.GoodsUnitMapper;
import com.jing.settlement.service.GoodsUnitService;

@Service("goodsUnitService")
public class GoodsUnitServiceImpl implements GoodsUnitService{

	@Resource
	private GoodsUnitMapper goodsUnitMapper;

	/**
	* 添加 商品单位
	*/
	@Override
	public void addGoodsUnit(GoodsUnit goodsUnit){
		goodsUnitMapper.addGoodsUnit(goodsUnit);
	}
	
	/**
	* 修改 商品单位
	*/
	@Override
	public void updateGoodsUnit(GoodsUnit goodsUnit){
		goodsUnitMapper.updateGoodsUnit(goodsUnit);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteGoodsUnitById(Integer id){
		goodsUnitMapper.deleteGoodsUnitById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public GoodsUnit getGoodsUnitById(Integer id){
		return goodsUnitMapper.getGoodsUnitById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findGoodsUnitListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(goodsUnitMapper.findGoodsUnitListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询商品单位
	 * @param param
	 * @return
	 */
	 @Override
	public List<GoodsUnit> findGoodsUnitList(Map<String, Object> param){
		return goodsUnitMapper.findGoodsUnitList(param);
	}
	
}