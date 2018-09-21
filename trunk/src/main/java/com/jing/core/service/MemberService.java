package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Member;

public interface MemberService {

	/**
	 * 添加 会员
	 */
	void addMember(Member member);

	/**
	 * 修改 会员
	 */
	void updateMember(Member member);

	/**
	 * 根据ID删除记录
	 */
	void deleteMemberById(String id);

	/**
	 * 根据ID查询记录
	 */
	Member getMemberById(String id);

	/**
	 * 分页查询
	 */
	PageInfo findMemberListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询会员
	 * 
	 * @param param
	 * @return
	 */
	List<Member> findMemberList(Map<String, Object> param);
}