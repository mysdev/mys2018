package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberPlus;

@Mapper
public interface MemberPlusMapper {

	/**
	* 添加 会员充值活动
	*/
	void addMemberPlus(MemberPlus memberPlus);
	
	/**
	* 修改 会员充值活动
	*/
	void updateMemberPlus(MemberPlus memberPlus);
	
	/**
	*根据ID删除记录
	*/
	void deleteMemberPlusById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	MemberPlus getMemberPlusById(Integer id);
	
	/**
	* 分页查询
	*/
	List<MemberPlus> findMemberPlusListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询会员充值活动
	 * @param param
	 * @return
	 */
	List<MemberPlus> findMemberPlusList(@Param("param") Map<String, Object> param);	
}