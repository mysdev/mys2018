package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.MemberRecordMapper;
import com.jing.core.model.entity.MemberRecord;
import com.jing.core.service.MemberRecordService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: MemberRecord
 * @Description: 会员充值记录服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("memberRecordService")
@Transactional(readOnly=true)
public class  MemberRecordServiceImpl implements MemberRecordService {	
//	private static final Logger logger = LoggerFactory.getLogger(MemberRecordServiceImpl.class);
	
	@Autowired
    private MemberRecordMapper memberRecordMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addMemberRecord
	 * @Description:添加会员充值记录
	 * @param memberRecord 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public MemberRecord addMemberRecord(MemberRecord memberRecord){
		int ret = memberRecordMapper.addMemberRecord(memberRecord);
		if(ret>0){
			return memberRecord;
		}
		return null;
	}
	
	/**
	 * @Title modifyMemberRecord
	 * @Description:修改会员充值记录
	 * @param memberRecord 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMemberRecord(MemberRecord memberRecord){
		return memberRecordMapper.modifyMemberRecord(memberRecord);
	}
	
	/**
	 * @Title: dropMemberRecordByRecordId
	 * @Description:删除会员充值记录
	 * @param recordId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberRecordByRecordId(Integer recordId){
		return memberRecordMapper.dropMemberRecordByRecordId(recordId);
	}
	
	/**
	 * @Title: queryMemberRecordByRecordId
	 * @Description:根据实体标识查询会员充值记录
	 * @param recordId 实体标识
	 * @return MemberRecord
	 */
	@Override
	public MemberRecord queryMemberRecordByRecordId(Integer recordId){
		return memberRecordMapper.queryMemberRecordByRecordId(recordId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryMemberRecordForPage
	 * @Description: 根据会员充值记录属性与分页信息分页查询会员充值记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberRecord 实体
	 * @return List<MemberRecord>
	 */
	@Override
	public Map<String, Object> queryMemberRecordForPage(Integer pagenum, Integer pagesize, String sort, MemberRecord memberRecord){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, MemberRecord.class);
		List<MemberRecord> entityList = memberRecordMapper.queryMemberRecordForPage(pageBounds, memberRecord);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, MemberRecord.class);
		}
		if (!entityList.isEmpty()) {
			PageList<MemberRecord> pagelist = (PageList<MemberRecord>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryMemberRecordByProperty
	 * @Description:根据属性查询会员充值记录
	 * @return List<MemberRecord>
	 */
	@Override
	public List<MemberRecord> queryMemberRecordByProperty(Map<String, Object> map){
		return memberRecordMapper.queryMemberRecordByProperty(map);
	}


}
