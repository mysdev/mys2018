package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.dao.MemberMoneyRecordMapper;
import com.jing.core.model.entity.MemberMoneyRecord;
import com.jing.core.service.MemberMoneyRecordService;

@Service("memberMoneyRecordService")
public class MemberMoneyRecordServiceImpl implements MemberMoneyRecordService {

	@Resource
	private MemberMoneyRecordMapper memberMoneyRecordMapper;

	/**
	 * 添加 会员金额流水
	 */
	@Override
	public void addMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord) {
		memberMoneyRecordMapper.addMemberMoneyRecord(memberMoneyRecord);
	}

	/**
	 * 修改 会员金额流水
	 */
	@Override
	public void updateMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord) {
		memberMoneyRecordMapper.updateMemberMoneyRecord(memberMoneyRecord);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteMemberMoneyRecordById(Integer id) {
		memberMoneyRecordMapper.deleteMemberMoneyRecordById(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public MemberMoneyRecord getMemberMoneyRecordById(Integer id) {
		return memberMoneyRecordMapper.getMemberMoneyRecordById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findMemberMoneyRecordListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(memberMoneyRecordMapper.findMemberMoneyRecordListPage(page, param));
	}

	/**
	 * 根据属性查询会员金额流水
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<MemberMoneyRecord> findMemberMoneyRecordList(Map<String, Object> param) {
		return memberMoneyRecordMapper.findMemberMoneyRecordList(param);
	}

}