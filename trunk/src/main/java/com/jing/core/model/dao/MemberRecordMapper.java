package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.MemberRecord;

/**
 * @ClassName: MemberRecordMapper
 * @Description: 会员充值记录映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface MemberRecordMapper {

	/**
	 * @Title: addMemberRecord
	 * @Description:添加会员充值记录
	 * @param memberRecord 实体
	 * @return Integer
	 */
	Integer addMemberRecord(MemberRecord memberRecord);
	
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
	 * @param pageBounds 分页信息
	 * @param memberRecord 实体
	 * @return List<MemberRecord>
	 */
	List<MemberRecord> queryMemberRecordForPage(PageBounds pageBounds, @Param("memberRecord") MemberRecord memberRecord);
	 
	 /**
	  * @Title: queryMemberRecordByProperty
	  * @Description:根据属性查询会员充值记录
	  * @return List<MemberRecord>
	  */
	 List<MemberRecord> queryMemberRecordByProperty(@Param("memberRecord") Map<String, Object> map);
	 
	 
	 
}
