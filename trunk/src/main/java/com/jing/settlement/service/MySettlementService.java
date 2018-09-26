package com.jing.settlement.service;

import com.jing.settlement.model.entity.Authorization;

/**
 * 授权码管理
 * @author Administrator
 *
 */
public interface MySettlementService {

	/**
	 * 根据房间号查询授权码
	 */
	Authorization getAuthorizationByRoomId(String roomId);
	
	/**
	 * 根据手牌编号查询授权码
	 * @param strapNo
	 * @return
	 */
	Authorization getAuthorizationByStrapNo(String strapNo);
	
	
	/**
	 *根据关键条件收缩想关联的授权码【同一个客户下的授权码】
	 */
	Authorization[] findAuthorizations(String keword);
	
	
	/**
	 * 结束授权码状态、授权码关联房牌状态、客户状态
	 * @param authorizationIds
	 */
	void resetAuthorizations(String[] authorizationIds);
	
	/**
	 * 暂结授权码
	 * @param authorizationIds
	 */
	void temporarily(String[] authorizationIds);
	
}
