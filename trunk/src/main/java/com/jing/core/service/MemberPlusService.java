package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberPlus;

public interface MemberPlusService {

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
	PageInfo findMemberPlusListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询会员充值活动
	 * @param param
	 * @return
	 */
	List<MemberPlus> findMemberPlusList(Map<String, Object> param);
}