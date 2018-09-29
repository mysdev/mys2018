package com.jing.settlement.service;

import java.util.List;

import com.jing.settlement.model.entity.Authorization;
import com.jing.system.user.entity.User;

/**
 * 客户相关组装接口
 * @author Administrator
 *
 */
public interface MyCustomerService {

	/**
	 * 开立一个客房
	 * @param roomId
	 */
	void rentRoom(String roomId,User user);
	
	/**
	 * 给已有客户增加一个客房
	 * @param customerId
	 * @param roomId
	 */
	void rentRoom(int customerId,String roomId,User user);
	
	/**
	 * 
	 * @param strapId
	 */
	void rentStrap(String strapId,User user);
	
	/**
	 * 给已有客户增加一个手环
	 * @param customerId
	 * @param roomId
	 */
	void rentStrap(int customerId,String strapId,User user);
	
	/**
	 * 取消授权码
	 * @param authorizationId
	 */
	void cancelAuthorization(String authorizationId,User user);
	
	/**
	 * 根据手牌ID、或者房间ID查询客户相关 授权
	 * @param keyword
	 * @return
	 */
	List<Authorization> findAuthorizations(String deviceId);
}
