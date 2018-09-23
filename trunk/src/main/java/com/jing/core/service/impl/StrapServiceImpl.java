package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.Strap;
import com.jing.core.model.dao.StrapMapper;
import com.jing.core.service.StrapService;
import com.jing.utils.PrimaryKey;

@Service("strapService")
public class StrapServiceImpl implements StrapService{

	@Resource
	private StrapMapper strapMapper;

	/**
	* 添加 手牌
	*/
	@Override
	public void addStrap(Strap strap){
		strap.setStrapId(PrimaryKey.getUUID());
		strapMapper.addStrap(strap);
	}
	
	/**
	* 修改 手牌
	*/
	@Override
	public void updateStrap(Strap strap){
		strapMapper.updateStrap(strap);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteStrapById(String id){
		strapMapper.deleteStrapById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Strap getStrapById(String id){
		return strapMapper.getStrapById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findStrapListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(strapMapper.findStrapListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询手牌
	 * @param param
	 * @return
	 */
	 @Override
	public List<Strap> findStrapList(Map<String, Object> param){
		return strapMapper.findStrapList(param);
	}
	
}