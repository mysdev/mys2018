package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.MemberIntegralRecord;

@Mapper
public interface MemberIntegralRecordMapper {

	/**
	* 添加 会员积分流水
	*/
	void addMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord);
	
	/**
	* 修改 会员积分流水
	*/
	void updateMemberIntegralRecord(MemberIntegralRecord memberIntegralRecord);
	
	/**
	*根据ID删除记录
	*/
	void deleteMemberIntegralRecordById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	MemberIntegralRecord getMemberIntegralRecordById(Integer id);
	
	/**
	* 分页查询
	*/
	List<MemberIntegralRecord> findMemberIntegralRecordListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询会员积分流水
	 * @param param
	 * @return
	 */
	List<MemberIntegralRecord> findMemberIntegralRecordList(@Param("param") Map<String, Object> param);	
}