package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.dao.MemberIntegralRecordMapper;
import com.jing.core.model.entity.MemberIntegralRecord;
import com.jing.core.service.MemberIntegralRecordService;

@Service("memberIntegralRecordService")
public class MemberIntegralRecordServiceImpl implements MemberIntegralRecordService {

	@Resource
	private MemberIntegralRecordMapper memberIntegralRecordMapper;

	/**
	 * 添加 会员积分流水
	 */
	@Override
	public void addMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord) {
		memberIntegralRecordMapper.addMemberIntegralRecord(memberIntegralRecord);
	}

	/**
	 * 修改 会员积分流水
	 */
	@Override
	public void updateMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord) {
		memberIntegralRecordMapper.updateMemberIntegralRecord(memberIntegralRecord);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteMemberIntegralRecordById(Integer id) {
		memberIntegralRecordMapper.deleteMemberIntegralRecordById(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public MemberIntegralRecord getMemberIntegralRecordById(Integer id) {
		return memberIntegralRecordMapper.getMemberIntegralRecordById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findMemberIntegralRecordListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(memberIntegralRecordMapper.findMemberIntegralRecordListPage(page, param));
	}

	/**
	 * 根据属性查询会员积分流水
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<MemberIntegralRecord> findMemberIntegralRecordList(Map<String, Object> param) {
		return memberIntegralRecordMapper.findMemberIntegralRecordList(param);
	}

}