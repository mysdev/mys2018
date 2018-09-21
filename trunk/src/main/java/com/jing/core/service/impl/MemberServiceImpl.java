package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.Member;
import com.jing.core.model.dao.MemberMapper;
import com.jing.core.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberMapper memberMapper;

	/**
	* 添加 会员
	*/
	@Override
	public void addMember(Member member){
		memberMapper.addMember(member);
	}
	
	/**
	* 修改 会员
	*/
	@Override
	public void updateMember(Member member){
		memberMapper.updateMember(member);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteMemberById(String id){
		memberMapper.deleteMemberById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Member getMemberById(String id){
		return memberMapper.getMemberById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findMemberListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(memberMapper.findMemberListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询会员
	 * @param param
	 * @return
	 */
	 @Override
	public List<Member> findMemberList(Map<String, Object> param){
		return memberMapper.findMemberList(param);
	}
	
}