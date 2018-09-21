package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberMoneyRecord;

public interface MemberMoneyRecordService {

	/**
	 * 添加 会员金额流水
	 */
	void addMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord);

	/**
	 * 修改 会员金额流水
	 */
	void updateMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord);

	/**
	 * 根据ID删除记录
	 */
	void deleteMemberMoneyRecordById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	MemberMoneyRecord getMemberMoneyRecordById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findMemberMoneyRecordListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询会员金额流水
	 * 
	 * @param param
	 * @return
	 */
	List<MemberMoneyRecord> findMemberMoneyRecordList(Map<String, Object> param);
}