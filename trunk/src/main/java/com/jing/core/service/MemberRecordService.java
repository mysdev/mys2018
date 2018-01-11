package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.MemberRecord;

/**
 * @ClassName: MemberRecord
 * @Description: 会员充值记录服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface MemberRecordService {

    /**
	 * @Title: addMemberRecord
	 * @Description:添加会员充值记录
	 * @param memberRecord 实体
	 * @return Integer
	 */
	MemberRecord addMemberRecord(MemberRecord memberRecord);
	
	/**
	 * @Title modifyMemberRecord
	 * @Description:修改会员充值记录
	 * @param memberRecord 实体
	 * @return Integer
	 */
	Integer modifyMemberRecord(MemberRecord memberRecord);
	
	/**
	 * @Title: dropMemberRecordByRecordId
	 * @Description:删除会员充值记录
	 * @param recordId 实体标识
	 * @return Integer
	 */
	Integer dropMemberRecordByRecordId(Integer recordId);
	
	/**
	 * @Title: queryMemberRecordByRecordId
	 * @Description:根据实体标识查询会员充值记录
	 * @param recordId 实体标识
	 * @return MemberRecord
	 */
	MemberRecord queryMemberRecordByRecordId(Integer recordId);
	 
	/**
	 * @Title: queryMemberRecordForPage
	 * @Description: 根据会员充值记录属性与分页信息分页查询会员充值记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberRecord 实体
	 * @return List<MemberRecord>
	 */
	Map<String, Object> queryMemberRecordForPage(Integer pagenum, Integer pagesize, String sort, MemberRecord memberRecord);
	 
	 /**
	 * @Title: queryMemberRecordByProperty
	 * @Description:根据属性查询会员充值记录
	 * @return List<MemberRecord>
	 */
	 List<MemberRecord> queryMemberRecordByProperty(Map<String, Object> map);	 
	 
}
