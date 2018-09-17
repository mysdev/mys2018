package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.MemberPlusMapper;
import com.jing.core.model.entity.MemberPlus;
import com.jing.core.service.MemberPlusService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: MemberPlus
 * @Description: 会员充值活动服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("memberPlusService")
@Transactional(readOnly = true)
public class MemberPlusServiceImpl implements MemberPlusService {
//	private static final Logger logger = LoggerFactory.getLogger(MemberPlusServiceImpl.class);

	@Autowired
	private MemberPlusMapper memberPlusMapper;

	@Autowired
	private PageService pageService; // 分页器

	/**
	 * @Title: addMemberPlus
	 * @Description:添加会员充值活动
	 * @param memberPlus
	 *            实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public MemberPlus addMemberPlus(MemberPlus memberPlus) {
		int ret = memberPlusMapper.addMemberPlus(memberPlus);
		if (ret > 0) {
			return memberPlus;
		}
		return null;
	}

	/**
	 * @Title modifyMemberPlus
	 * @Description:修改会员充值活动
	 * @param memberPlus
	 *            实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMemberPlus(MemberPlus memberPlus) {
		return memberPlusMapper.modifyMemberPlus(memberPlus);
	}

	/**
	 * @Title: dropMemberPlusByPlusId
	 * @Description:删除会员充值活动
	 * @param plusId
	 *            实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberPlusByPlusId(Integer plusId) {
		return memberPlusMapper.dropMemberPlusByPlusId(plusId);
	}

	/**
	 * @Title: queryMemberPlusByPlusId
	 * @Description:根据实体标识查询会员充值活动
	 * @param plusId
	 *            实体标识
	 * @return MemberPlus
	 */
	@Override
	public MemberPlus queryMemberPlusByPlusId(Integer plusId) {
		return memberPlusMapper.queryMemberPlusByPlusId(plusId);
	}

	/**
	 * @Title: queryMemberPlusForPage
	 * @Description: 根据会员充值活动属性与分页信息分页查询会员充值活动信息
	 * @param pagenum
	 *            页
	 * @param pagesize
	 *            页大小
	 * @param sort
	 *            排序
	 * @param memberPlus
	 *            实体
	 * @return List<MemberPlus>
	 */
	@Override
	public Map<String, Object> queryMemberPlusForPage(Integer pagenum, Integer pagesize, String sort,
			MemberPlus memberPlus) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, MemberPlus.class);
		List<MemberPlus> entityList = memberPlusMapper.queryMemberPlusForPage(pageBounds, memberPlus);
		if (null != sort && sort.length() > 0) {
			pageBounds.setOrdersByJson(sort, MemberPlus.class);
		}
		if (!entityList.isEmpty()) {
			PageList<MemberPlus> pagelist = (PageList<MemberPlus>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}

	/**
	 * @Title: queryMemberPlusByProperty
	 * @Description:根据属性查询会员充值活动
	 * @return List<MemberPlus>
	 */
	@Override
	public List<MemberPlus> queryMemberPlusByProperty(Map<String, Object> map) {
		return memberPlusMapper.queryMemberPlusByProperty(map);
	}

	/**
	 * 根据金额查询匹配的活动,没匹配到返回空值，匹配到返回活动记录
	 * 
	 * @param amount
	 * @return
	 */
	@Override
	public MemberPlus queryMemberPlusByAmount(Integer amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
