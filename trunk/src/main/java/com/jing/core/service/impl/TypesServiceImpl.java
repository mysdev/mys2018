package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.Types;
import com.jing.core.model.dao.TypesMapper;
import com.jing.core.service.TypesService;

@Service("typesService")
public class TypesServiceImpl implements TypesService{

	@Resource
	private TypesMapper typesMapper;

	/**
	* 添加 类型配置
	*/
	@Override
	public void addTypes(Types types){
		typesMapper.addTypes(types);
	}
	
	/**
	* 修改 类型配置
	*/
	@Override
	public void updateTypes(Types types){
		typesMapper.updateTypes(types);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteTypesById(Integer id){
		typesMapper.deleteTypesById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Types getTypesById(Integer id){
		return typesMapper.getTypesById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findTypesListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(typesMapper.findTypesListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询类型配置
	 * @param param
	 * @return
	 */
	 @Override
	public List<Types> findTypesList(Map<String, Object> param){
		return typesMapper.findTypesList(param);
	}
	
}