package com.jing.core.service;

import com.jing.system.user.entity.User;

public interface MyMemberService {

	/**
	 * 消费
	 * @param memberId
	 * @param amount
	 */
	void pay(String memberId,float amount,String remark,User user);
	
	/**
	 * 充值
	 */
	void recharge(String memberId,float amount,String remark,User user);
}
