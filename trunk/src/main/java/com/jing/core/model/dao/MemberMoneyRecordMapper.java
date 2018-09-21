package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberMoneyRecord;

@Mapper
public interface MemberMoneyRecordMapper {

	/**
	* 添加 会员金额流水
	*/
	void addMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord);
	
	/**
	* 修改 会员金额流水
	*/
	void updateMemberMoneyRecord(MemberMoneyRecord memberMoneyRecord);
	
	/**
	*根据ID删除记录
	*/
	void deleteMemberMoneyRecordById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	MemberMoneyRecord getMemberMoneyRecordById(Integer id);
	
	/**
	* 分页查询
	*/
	List<MemberMoneyRecord> findMemberMoneyRecordListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询会员金额流水
	 * @param param
	 * @return
	 */
	List<MemberMoneyRecord> findMemberMoneyRecordList(@Param("param") Map<String, Object> param);	
}