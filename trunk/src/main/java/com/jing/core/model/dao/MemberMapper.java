package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Member;

/**
 * @ClassName: MemberMapper
 * @Description: 会员映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface MemberMapper {

	/**
	* 添加 会员
	*/
	void addMember(Member member);
	
	/**
	* 修改 会员
	*/
	void updateMember(Member member);
	
	/**
	*根据ID删除记录
	*/
	void deleteMemberById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Member getMemberById(String id);
	
	/**
	* 分页查询
	*/
	List<Member> findMemberListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询会员
	 * @param param
	 * @return
	 */
	List<Member> findMemberList(@Param("param") Map<String, Object> param);	
	 
	 
	 
}
