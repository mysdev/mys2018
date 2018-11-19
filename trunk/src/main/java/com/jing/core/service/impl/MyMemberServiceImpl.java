package com.jing.core.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.core.model.entity.EmployeeCommission;
import com.jing.core.model.entity.Member;
import com.jing.core.model.entity.MemberMoneyRecord;
import com.jing.core.model.entity.MemberPlus;
import com.jing.core.service.EmployeeCommissionService;
import com.jing.core.service.MemberMoneyRecordService;
import com.jing.core.service.MemberPlusService;
import com.jing.core.service.MemberService;
import com.jing.core.service.MyMemberService;
import com.jing.system.user.entity.User;

@Service("myMemberService")
public class MyMemberServiceImpl implements MyMemberService{

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberMoneyRecordService memberMoneyRecordService;
	@Autowired
	private MemberPlusService memberPlusService;
	@Autowired
	private EmployeeCommissionService employeeCommissionService;
	
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
	public synchronized void recharge(String memberId, int amount,String remark,User user,String employeeId) {
		Member member = memberService.getMemberById(memberId);
		if(member ==null) {
			throw new CustomException("会员信息不存在.");
		}
		BigDecimal balance = member.getBalance();
		//充值金额
		BigDecimal res = balance.add(new BigDecimal(amount));
		member.setBalance(res);
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
		//活动
		MemberPlus plus = memberPlusService.findMemberPlus(amount);
		if(plus != null && plus.getGiftMoney().intValue()>0) {
			BigDecimal giftMoney = plus.getGiftMoney();//赠送金额
			BigDecimal gif = res.add(giftMoney);
			member.setBalance(gif);
			MemberMoneyRecord grecord = new MemberMoneyRecord();
			grecord.setMemberId(memberId);
			grecord.setMoney(new BigDecimal(amount));
			grecord.setRtype(1);
			grecord.setRemark(plus.getPlusName());
			grecord.setCreatedDateNow();
			grecord.setUpdatedDateNow();
			grecord.setUpdatedBy(user.getUserId());
			grecord.setCreatedBy(user.getUserId());
			grecord.setBalance(gif);
			memberMoneyRecordService.addMemberMoneyRecord(grecord);
			//提成...
			BigDecimal money = plus.getMoney();
			EmployeeCommission employeeCommission = new EmployeeCommission();
			employeeCommission.setMoney(money);
			employeeCommission.setEmployeeId(employeeId);
			employeeCommission.setCause("会员充值提成");
			employeeCommission.setRemark(remark);
			employeeCommissionService.addEmployeeCommission(employeeCommission);
		}
		memberService.updateMember(member);
	}

}
