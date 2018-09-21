package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberLevel;

@Mapper
public interface MemberLevelMapper {

	/**
	* 添加 会员体系
	*/
	void addMemberLevel(MemberLevel memberLevel);
	
	/**
	* 修改 会员体系
	*/
	void updateMemberLevel(MemberLevel memberLevel);
	
	/**
	*根据ID删除记录
	*/
	void deleteMemberLevelById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	MemberLevel getMemberLevelById(Integer id);
	
	/**
	* 分页查询
	*/
	List<MemberLevel> findMemberLevelListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询会员体系
	 * @param param
	 * @return
	 */
	List<MemberLevel> findMemberLevelList(@Param("param") Map<String, Object> param);	
}