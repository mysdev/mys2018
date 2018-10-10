package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.TypesBind;
import com.jing.core.model.dao.TypesBindMapper;
import com.jing.core.service.TypesBindService;

@Service("typesBindService")
public class TypesBindServiceImpl implements TypesBindService{

	@Resource
	private TypesBindMapper typesBindMapper;

	/**
	* 添加 类型消费绑定
	*/
	@Override
	public void addTypesBind(TypesBind typesBind){
		typesBindMapper.addTypesBind(typesBind);
	}
	
	/**
	* 修改 类型消费绑定
	*/
	@Override
	public void updateTypesBind(TypesBind typesBind){
		typesBindMapper.updateTypesBind(typesBind);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteTypesBindById(Integer id){
		typesBindMapper.deleteTypesBindById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public TypesBind getTypesBindById(Integer id){
		return typesBindMapper.getTypesBindById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findTypesBindListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(typesBindMapper.findTypesBindListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询类型消费绑定
	 * @param param
	 * @return
	 */
	 @Override
	public List<TypesBind> findTypesBindList(Map<String, Object> param){
		return typesBindMapper.findTypesBindList(param);
	}
	
}