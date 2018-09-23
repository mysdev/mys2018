package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberLevel;

public interface MemberLevelService {

	/**
	 * 添加 会员体系
	 */
	void addMemberLevel(MemberLevel memberLevel);

	/**
	 * 修改 会员体系
	 */
	void updateMemberLevel(MemberLevel memberLevel);

	/**
	 * 根据ID删除记录
	 */
	void deleteMemberLevelById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	MemberLevel getMemberLevelById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findMemberLevelListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询会员体系
	 * 
	 * @param param
	 * @return
	 */
	List<MemberLevel> findMemberLevelList(Map<String, Object> param);
}