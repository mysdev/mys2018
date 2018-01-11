package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.MemberPlus;

/**
 * @ClassName: MemberPlus
 * @Description: 会员充值活动服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface MemberPlusService {

    /**
	 * @Title: addMemberPlus
	 * @Description:添加会员充值活动
	 * @param memberPlus 实体
	 * @return Integer
	 */
	MemberPlus addMemberPlus(MemberPlus memberPlus);
	
	/**
	 * @Title modifyMemberPlus
	 * @Description:修改会员充值活动
	 * @param memberPlus 实体
	 * @return Integer
	 */
	Integer modifyMemberPlus(MemberPlus memberPlus);
	
	/**
	 * @Title: dropMemberPlusByPlusId
	 * @Description:删除会员充值活动
	 * @param plusId 实体标识
	 * @return Integer
	 */
	Integer dropMemberPlusByPlusId(Integer plusId);
	
	/**
	 * @Title: queryMemberPlusByPlusId
	 * @Description:根据实体标识查询会员充值活动
	 * @param plusId 实体标识
	 * @return MemberPlus
	 */
	MemberPlus queryMemberPlusByPlusId(Integer plusId);
	 
	/**
	 * @Title: queryMemberPlusForPage
	 * @Description: 根据会员充值活动属性与分页信息分页查询会员充值活动信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberPlus 实体
	 * @return List<MemberPlus>
	 */
	Map<String, Object> queryMemberPlusForPage(Integer pagenum, Integer pagesize, String sort, MemberPlus memberPlus);
	 
	 /**
	 * @Title: queryMemberPlusByProperty
	 * @Description:根据属性查询会员充值活动
	 * @return List<MemberPlus>
	 */
	 List<MemberPlus> queryMemberPlusByProperty(Map<String, Object> map);	 
	 
}
