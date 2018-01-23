package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Member;

/**
 * @ClassName: Member
 * @Description: 会员服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface MemberService {

    /**
	 * @Title: addMember
	 * @Description:添加会员
	 * @param member 实体
	 * @return Integer
	 */
	Member addMember(Member member);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param member 实体
	 * @return List<Member>
	 */
	Map<String, Object> queryMemberForPage(Integer pagenum, Integer pagesize, String sort, Member member);
	 
	 /**
	 * @Title: queryMemberByProperty
	 * @Description:根据属性查询会员
	 * @return List<Member>
	 */
	 List<Member> queryMemberByProperty(Map<String, Object> map);	 
	 
	 /**
	  * 会员消费-减余额
	  * @param memberId 会员号
	  * @param amount 实际消费金额
	  */
	 void consumption(String memberId,Integer amount);
	 
	 /**
	  * 会员充值
	  * @param memberId 会员号
	  * @param amount 实际充值金额
	  */
	 Integer recharge(String memberId,Integer amount);
	 
	 /**
	  * 根据电话号码查询会员信息
	  * @param phone
	  * @return
	  */
	 Member findMemberByPhone(String phone);
	 
	 /**
	  * 根据会员卡查询会员信息
	  * @param phone
	  * @return
	  */
	 Member findMemberByCard(String cardNo);
}
