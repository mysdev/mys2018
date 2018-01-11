package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.MemberLevel;

/**
 * @ClassName: MemberLevel
 * @Description: 会员体系服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface MemberLevelService {

    /**
	 * @Title: addMemberLevel
	 * @Description:添加会员体系
	 * @param memberLevel 实体
	 * @return Integer
	 */
	MemberLevel addMemberLevel(MemberLevel memberLevel);
	
	/**
	 * @Title modifyMemberLevel
	 * @Description:修改会员体系
	 * @param memberLevel 实体
	 * @return Integer
	 */
	Integer modifyMemberLevel(MemberLevel memberLevel);
	
	/**
	 * @Title: dropMemberLevelByLevelId
	 * @Description:删除会员体系
	 * @param levelId 实体标识
	 * @return Integer
	 */
	Integer dropMemberLevelByLevelId(Integer levelId);
	
	/**
	 * @Title: queryMemberLevelByLevelId
	 * @Description:根据实体标识查询会员体系
	 * @param levelId 实体标识
	 * @return MemberLevel
	 */
	MemberLevel queryMemberLevelByLevelId(Integer levelId);
	 
	/**
	 * @Title: queryMemberLevelForPage
	 * @Description: 根据会员体系属性与分页信息分页查询会员体系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberLevel 实体
	 * @return List<MemberLevel>
	 */
	Map<String, Object> queryMemberLevelForPage(Integer pagenum, Integer pagesize, String sort, MemberLevel memberLevel);
	 
	 /**
	 * @Title: queryMemberLevelByProperty
	 * @Description:根据属性查询会员体系
	 * @return List<MemberLevel>
	 */
	 List<MemberLevel> queryMemberLevelByProperty(Map<String, Object> map);	 
	 
}
