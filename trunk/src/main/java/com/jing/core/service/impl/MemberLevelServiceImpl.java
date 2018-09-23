package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.dao.MemberLevelMapper;
import com.jing.core.model.entity.MemberLevel;
import com.jing.core.service.MemberLevelService;
import com.jing.core.util.MemberLevelCache;

@Service("memberLevelService")
public class MemberLevelServiceImpl implements MemberLevelService {

	@Resource
	private MemberLevelMapper memberLevelMapper;

	/**
	 * 添加 会员体系
	 */
	@Override
	public void addMemberLevel(MemberLevel memberLevel) {
		memberLevelMapper.addMemberLevel(memberLevel);
		MemberLevelCache.load();
	}

	/**
	 * 修改 会员体系
	 */
	@Override
	public void updateMemberLevel(MemberLevel memberLevel) {
		memberLevelMapper.updateMemberLevel(memberLevel);
		MemberLevelCache.load();
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteMemberLevelById(Integer id) {
		memberLevelMapper.deleteMemberLevelById(id);
		MemberLevelCache.load();
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public MemberLevel getMemberLevelById(Integer id) {
		return memberLevelMapper.getMemberLevelById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findMemberLevelListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(memberLevelMapper.findMemberLevelListPage(page, param));
	}

	/**
	 * 根据属性查询会员体系
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<MemberLevel> findMemberLevelList(Map<String, Object> param) {
		return memberLevelMapper.findMemberLevelList(param);
	}

}