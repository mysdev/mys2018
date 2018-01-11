package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;
import java.util.UUID;


import com.jing.core.model.entity.Member;
import com.jing.core.model.dao.MemberMapper;
import com.jing.core.service.MemberService;

/**
 * @ClassName: Member
 * @Description: 会员服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("memberService")
@Transactional(readOnly=true)
public class  MemberServiceImpl implements MemberService {	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
    private MemberMapper memberMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addMember
	 * @Description:添加会员
	 * @param member 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Member addMember(Member member){
		member.setMemberId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = memberMapper.addMember(member);
		if(ret>0){
			return member;
		}
		return null;
	}
	
	/**
	 * @Title modifyMember
	 * @Description:修改会员
	 * @param member 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMember(Member member){
		return memberMapper.modifyMember(member);
	}
	
	/**
	 * @Title: dropMemberByMemberId
	 * @Description:删除会员
	 * @param memberId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberByMemberId(String memberId){
		return memberMapper.dropMemberByMemberId(memberId);
	}
	
	/**
	 * @Title: queryMemberByMemberId
	 * @Description:根据实体标识查询会员
	 * @param memberId 实体标识
	 * @return Member
	 */
	@Override
	public Member queryMemberByMemberId(String memberId){
		return memberMapper.queryMemberByMemberId(memberId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryMemberForPage
	 * @Description: 根据会员属性与分页信息分页查询会员信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param member 实体
	 * @return List<Member>
	 */
	@Override
	public Map<String, Object> queryMemberForPage(Integer pagenum, Integer pagesize, String sort, Member member){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Member.class);
		List<Member> entityList = memberMapper.queryMemberForPage(pageBounds, member);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Member.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Member> pagelist = (PageList<Member>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryMemberByProperty
	 * @Description:根据属性查询会员
	 * @return List<Member>
	 */
	@Override
	public List<Member> queryMemberByProperty(Map<String, Object> map){
		return memberMapper.queryMemberByProperty(map);
	}


}
