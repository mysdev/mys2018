package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberIntegralRecord;

public interface MemberIntegralRecordService {

	/**
	 * 添加 会员积分流水
	 */
	void addMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord);

	/**
	 * 修改 会员积分流水
	 */
	void updateMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord);

	/**
	 * 根据ID删除记录
	 */
	void deleteMemberIntegralRecordById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	MemberIntegralRecord getMemberIntegralRecordById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findMemberIntegralRecordListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询会员积分流水
	 * 
	 * @param param
	 * @return
	 */
	List<MemberIntegralRecord> findMemberIntegralRecordList(Map<String, Object> param);
}