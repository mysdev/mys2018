package com.jing.core.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.core.model.dao.MemberMapper;
import com.jing.core.model.entity.Member;
import com.jing.core.model.entity.MemberPlus;
import com.jing.core.service.MemberPlusService;
import com.jing.core.service.MemberService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Member
 * @Description: 会员服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("memberService")
@Transactional(readOnly=true)
public class  MemberServiceImpl implements MemberService {	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
    private MemberMapper memberMapper;   
	@Autowired
	private MemberPlusService memberPlusService;
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addMember
	 * @Description:添加会员
	 * @param member 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Member addMember(Member member){
		member.setMemberId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = memberMapper.addMember(member);
		if(ret>0){
			return member;
		}
		return null;
	}
	
	/**
	 * @Title modifyMember
	 * @Description:修改会员
	 * @param member 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMember(Member member){
		return memberMapper.modifyMember(member);
	}
	
	/**
	 * @Title: dropMemberByMemberId
	 * @Description:删除会员
	 * @param memberId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberByMemberId(String memberId){
		return memberMapper.dropMemberByMemberId(memberId);
	}
	
	/**
	 * @Title: queryMemberByMemberId
	 * @Description:根据实体标识查询会员
	 * @param memberId 实体标识
	 * @return Member
	 */
	@Override
	public Member queryMemberByMemberId(String memberId){
		return memberMapper.queryMemberByMemberId(memberId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryMemberForPage
	 * @Description: 根据会员属性与分页信息分页查询会员信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param member 实体
	 * @return List<Member>
	 */
	@Override
	public Map<String, Object> queryMemberForPage(Integer pagenum, Integer pagesize, String sort, Member member){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Member.class);
		List<Member> entityList = memberMapper.queryMemberForPage(pageBounds, member);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Member.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Member> pagelist = (PageList<Member>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryMemberByProperty
	 * @Description:根据属性查询会员
	 * @return List<Member>
	 */
	@Override
	public List<Member> queryMemberByProperty(Map<String, Object> map){
		return memberMapper.queryMemberByProperty(map);
	}

	
	/**
	 * 消费
	 */
	@Override
	public synchronized void consumption(String memberId, Integer amount) {
		BigDecimal a = new BigDecimal(amount);
		Member member = this.queryMemberByMemberId(memberId);
		if(member==null) {
			throw new NotFoundException("会员");
		}
		BigDecimal ye = member.getBalance();
		BigDecimal totalFee = member.getTotalFee();
		if(ye.intValue() < amount) {
			throw new CustomException(-1, "余额不足");
		}
		//计算余额
		ye = ye.subtract(a);
		//计算总消费
		totalFee = totalFee.add(a);
		//计算成长值
		//计算积分
		member.setBalance(ye);
		member.setTotalFee(totalFee);
		this.modifyMember(member);
	}
	
	@Override
	public Integer recharge(String memberId, Integer amount) {
		BigDecimal a = new BigDecimal(amount);
		Member member = this.queryMemberByMemberId(memberId);
		if(member==null) {
			throw new NotFoundException("会员");
		}
		BigDecimal balance = member.getBalance();
		//计算金额是否达标赠送金额[会员充值活动]
		MemberPlus mp = memberPlusService.queryMemberPlusByAmount(amount);
		if(mp !=null) {
			balance = balance.add(mp.getGiftMoney());
			balance = balance.add(a);
		}else {
			balance = balance.add(a);
		}
		member.setBalance(balance);
		return this.modifyMember(member);
	}

	@Override
	public Member findMemberByPhone(String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", phone);
		List<Member> list = queryMemberByProperty(map);
		if(list !=null && !list.isEmpty()) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Member findMemberByCard(String cardNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberCard", cardNo);
		List<Member> list = queryMemberByProperty(map);
		if(list !=null && !list.isEmpty()) {
			return list.get(0);
		}else {
			return null;
		}
	}

}
