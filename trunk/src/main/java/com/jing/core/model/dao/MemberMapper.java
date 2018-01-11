package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
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
	 * @Title: addMember
	 * @Description:添加会员
	 * @param member 实体
	 * @return Integer
	 */
	Integer addMember(Member member);
	
	/**
	 * @Title modifyMember
	 * @Description:修改会员
	 * @param member 实体
	 * @return Integer
	 */
	Integer modifyMember(Member member);
	
	/**
	 * @Title: dropMemberByMemberId
	 * @Description:删除会员
	 * @param memberId 实体标识
	 * @return Integer
	 */
	Integer dropMemberByMemberId(String memberId);
	
	/**
	 * @Title: queryMemberByMemberId
	 * @Description:根据实体标识查询会员
	 * @param memberId 实体标识
	 * @return Member
	 */
	Member queryMemberByMemberId(String memberId);
	 
	/**
	 * @Title: queryMemberForPage
	 * @Description: 根据会员属性与分页信息分页查询会员信息
	 * @param pageBounds 分页信息
	 * @param member 实体
	 * @return List<Member>
	 */
	List<Member> queryMemberForPage(PageBounds pageBounds, @Param("member") Member member);
	 
	 /**
	  * @Title: queryMemberByProperty
	  * @Description:根据属性查询会员
	  * @return List<Member>
	  */
	 List<Member> queryMemberByProperty(@Param("member") Map<String, Object> map);
	 
	 
	 
}
