package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.MemberLevel;

/**
 * @ClassName: MemberLevelMapper
 * @Description: 会员体系映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface MemberLevelMapper {

	/**
	 * @Title: addMemberLevel
	 * @Description:添加会员体系
	 * @param memberLevel 实体
	 * @return Integer
	 */
	Integer addMemberLevel(MemberLevel memberLevel);
	
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
	 * @param pageBounds 分页信息
	 * @param memberLevel 实体
	 * @return List<MemberLevel>
	 */
	List<MemberLevel> queryMemberLevelForPage(PageBounds pageBounds, @Param("memberLevel") MemberLevel memberLevel);
	 
	 /**
	  * @Title: queryMemberLevelByProperty
	  * @Description:根据属性查询会员体系
	  * @return List<MemberLevel>
	  */
	 List<MemberLevel> queryMemberLevelByProperty(@Param("memberLevel") Map<String, Object> map);
	 
	 
	 
}
