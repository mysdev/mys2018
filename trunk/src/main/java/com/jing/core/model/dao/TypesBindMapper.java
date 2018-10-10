package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.TypesBind;

@Mapper
public interface TypesBindMapper {

	/**
	* 添加 类型消费绑定
	*/
	void addTypesBind(TypesBind typesBind);
	
	/**
	* 修改 类型消费绑定
	*/
	void updateTypesBind(TypesBind typesBind);
	
	/**
	*根据ID删除记录
	*/
	void deleteTypesBindById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	TypesBind getTypesBindById(Integer id);
	
	/**
	* 分页查询
	*/
	List<TypesBind> findTypesBindListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询类型消费绑定
	 * @param param
	 * @return
	 */
	List<TypesBind> findTypesBindList(@Param("param") Map<String, Object> param);	
}