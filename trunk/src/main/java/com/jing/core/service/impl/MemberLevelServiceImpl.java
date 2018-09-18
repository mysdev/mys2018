package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.MemberLevelMapper;
import com.jing.core.model.entity.MemberLevel;
import com.jing.core.service.MemberLevelService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: MemberLevel
 * @Description: 会员体系服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("memberLevelService")
@Transactional(readOnly=true)
public class  MemberLevelServiceImpl implements MemberLevelService {	
//	private static final Logger logger = LoggerFactory.getLogger(MemberLevelServiceImpl.class);
	
	@Autowired
    private MemberLevelMapper memberLevelMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addMemberLevel
	 * @Description:添加会员体系
	 * @param memberLevel 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public MemberLevel addMemberLevel(MemberLevel memberLevel){
		int ret = memberLevelMapper.addMemberLevel(memberLevel);
		if(ret>0){
			return memberLevel;
		}
		return null;
	}
	
	/**
	 * @Title modifyMemberLevel
	 * @Description:修改会员体系
	 * @param memberLevel 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMemberLevel(MemberLevel memberLevel){
		return memberLevelMapper.modifyMemberLevel(memberLevel);
	}
	
	/**
	 * @Title: dropMemberLevelByLevelId
	 * @Description:删除会员体系
	 * @param levelId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberLevelByLevelId(Integer levelId){
		return memberLevelMapper.dropMemberLevelByLevelId(levelId);
	}
	
	/**
	 * @Title: queryMemberLevelByLevelId
	 * @Description:根据实体标识查询会员体系
	 * @param levelId 实体标识
	 * @return MemberLevel
	 */
	@Override
	public MemberLevel queryMemberLevelByLevelId(Integer levelId){
		return memberLevelMapper.queryMemberLevelByLevelId(levelId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryMemberLevelForPage
	 * @Description: 根据会员体系属性与分页信息分页查询会员体系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberLevel 实体
	 * @return List<MemberLevel>
	 */
	@Override
	public Map<String, Object> queryMemberLevelForPage(Integer pagenum, Integer pagesize, String sort, MemberLevel memberLevel){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, MemberLevel.class);
		List<MemberLevel> entityList = memberLevelMapper.queryMemberLevelForPage(pageBounds, memberLevel);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, MemberLevel.class);
		}
		if (!entityList.isEmpty()) {
			PageList<MemberLevel> pagelist = (PageList<MemberLevel>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryMemberLevelByProperty
	 * @Description:根据属性查询会员体系
	 * @return List<MemberLevel>
	 */
	@Override
	public List<MemberLevel> queryMemberLevelByProperty(Map<String, Object> map){
		return memberLevelMapper.queryMemberLevelByProperty(map);
	}


}
