package com.jing.core.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.core.model.entity.Member;
import com.jing.core.model.entity.MemberMoneyRecord;
import com.jing.core.service.MemberMoneyRecordService;
import com.jing.core.service.MemberService;
import com.jing.core.service.MyMemberService;
import com.jing.system.user.entity.User;

@Service("myMemberService")
public class MyMemberServiceImpl implements MyMemberService{

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberMoneyRecordService memberMoneyRecordService;
//	@Autowired
//	private memberp
	
	@Override
	@Transactional
	public void pay(String memberId, float amount,String remark,User user) {
		Member member = memberService.getMemberById(memberId);
		if(member ==null) {
			throw new CustomException("会员信息不存在.");
		}
		if(member.getBalance().floatValue()<amount) {
			throw new CustomException("余额不足.");
		}
		BigDecimal res = member.getBalance().subtract(new BigDecimal(amount));
		member.setBalance(res);
		memberService.updateMember(member);
		
		MemberMoneyRecord record = new MemberMoneyRecord();
		record.setMemberId(memberId);
		record.setMoney(new BigDecimal(amount));
		record.setRtype(2);
		record.setRemark(remark);
		record.setCreatedDateNow();
		record.setUpdatedDateNow();
		record.setUpdatedBy(user.getUserId());
		record.setCreatedBy(user.getUserId());
		record.setBalance(res);
		memberMoneyRecordService.addMemberMoneyRecord(record);
	}

	@Override
	@Transactional
	public synchronized void recharge(String memberId, float amount,String remark,User user) {
		Member member = memberService.getMemberById(memberId);
		if(member ==null) {
			throw new CustomException("会员信息不存在.");
		}
		BigDecimal balance = member.getBalance();
		BigDecimal res = balance.add(new BigDecimal(amount));
		member.setBalance(res);
		memberService.updateMember(member);
		
		MemberMoneyRecord record = new MemberMoneyRecord();
		record.setMemberId(memberId);
		record.setMoney(new BigDecimal(amount));
		record.setRtype(1);
		record.setRemark(remark);
		record.setCreatedDateNow();
		record.setUpdatedDateNow();
		record.setUpdatedBy(user.getUserId());
		record.setCreatedBy(user.getUserId());
		record.setBalance(res);
		memberMoneyRecordService.addMemberMoneyRecord(record);
	}

}
