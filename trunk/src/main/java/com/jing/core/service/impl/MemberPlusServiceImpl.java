package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.MemberPlus;
import com.jing.core.model.dao.MemberPlusMapper;
import com.jing.core.service.MemberPlusService;

@Service("memberPlusService")
public class MemberPlusServiceImpl implements MemberPlusService{

	@Resource
	private MemberPlusMapper memberPlusMapper;

	/**
	* 添加 会员充值活动
	*/
	@Override
	public void addMemberPlus(MemberPlus memberPlus){
		memberPlusMapper.addMemberPlus(memberPlus);
	}
	
	/**
	* 修改 会员充值活动
	*/
	@Override
	public void updateMemberPlus(MemberPlus memberPlus){
		memberPlusMapper.updateMemberPlus(memberPlus);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteMemberPlusById(Integer id){
		memberPlusMapper.deleteMemberPlusById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public MemberPlus getMemberPlusById(Integer id){
		return memberPlusMapper.getMemberPlusById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findMemberPlusListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(memberPlusMapper.findMemberPlusListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询会员充值活动
	 * @param param
	 * @return
	 */
	 @Override
	public List<MemberPlus> findMemberPlusList(Map<String, Object> param){
		return memberPlusMapper.findMemberPlusList(param);
	}

	@Override
	public MemberPlus findMemberPlus(int amount) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", "0");
		List<MemberPlus> list = this.findMemberPlusList(param);
		if(list==null || list.size()==0) {
			return null;
		}
		for (MemberPlus memberPlus : list) {
			if(amount> memberPlus.getPlusMoney().intValue()) {
				return memberPlus;
			}
		}
		return null;
	}
	
}