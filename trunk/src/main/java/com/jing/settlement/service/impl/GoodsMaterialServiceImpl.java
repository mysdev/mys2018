package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.GoodsMaterial;
import com.jing.settlement.model.dao.GoodsMaterialMapper;
import com.jing.settlement.service.GoodsMaterialService;

@Service("goodsMaterialService")
public class GoodsMaterialServiceImpl implements GoodsMaterialService{

	@Resource
	private GoodsMaterialMapper goodsMaterialMapper;

	/**
	* 添加 基本原料
	*/
	@Override
	public void addGoodsMaterial(GoodsMaterial goodsMaterial){
		goodsMaterialMapper.addGoodsMaterial(goodsMaterial);
	}
	
	/**
	* 修改 基本原料
	*/
	@Override
	public void updateGoodsMaterial(GoodsMaterial goodsMaterial){
		goodsMaterialMapper.updateGoodsMaterial(goodsMaterial);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteGoodsMaterialById(Integer id){
		goodsMaterialMapper.deleteGoodsMaterialById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public GoodsMaterial getGoodsMaterialById(Integer id){
		return goodsMaterialMapper.getGoodsMaterialById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findGoodsMaterialListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(goodsMaterialMapper.findGoodsMaterialListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询基本原料
	 * @param param
	 * @return
	 */
	 @Override
	public List<GoodsMaterial> findGoodsMaterialList(Map<String, Object> param){
		return goodsMaterialMapper.findGoodsMaterialList(param);
	}
	
}