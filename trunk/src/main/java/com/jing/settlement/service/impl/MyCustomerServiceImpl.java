package com.jing.settlement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.exception.CustomException;
import com.jing.core.model.entity.Room;
import com.jing.core.model.entity.Strap;
import com.jing.core.model.entity.Types;
import com.jing.core.model.entity.TypesBind;
import com.jing.core.service.RoomService;
import com.jing.core.service.StrapService;
import com.jing.core.service.TypesService;
import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.service.AuthorizationService;
import com.jing.settlement.service.CustomerService;
import com.jing.settlement.service.MyCustomerService;
import com.jing.system.user.entity.User;
import com.jing.trade.service.MyTradeService;

@Service("myCustomerService")
@Transactional(readOnly = false)
public class MyCustomerServiceImpl implements MyCustomerService {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private StrapService strapService;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private TypesService typesService;
	@Autowired
	private MyTradeService myTradeService;

	@Override
	public void rentRoom(String roomId, User user) {
		Room room = roomService.getRoomById(roomId);
		if (room == null) {
			throw new CustomException("客房不存在.");
		} else if (room.getStatus() != 0) {
			throw new CustomException("客房不可用.");
		}

		// 创建客户
		Customer customer = new Customer();
		customer.setCustomerName(room.getRoomName());
		customer.setNote(room.getRoomName() + "客人");
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);

		// 创建授权码
		Authorization authorization = new Authorization();
		authorization.setCustomerId(customer.getCustomerId());// 客户ID
		authorization.setTypes(room.getTypes());
		authorization.setDeviceId(room.getRoomId());// 终端标识
		authorization.setStatus(0);
		authorization.setCreatedBy(user.getUserId());
		authorization.setCreatedDateNow();
		authorization.setUpdatedBy(user.getUserId());
		authorization.setUpdatedDateNow();
		authorizationService.addAuthorization(authorization);
		// 基础消费
		this.consumption(authorization.getAuthorizationId(),room.getTypes());
		// 更新房间状态
		room.setRoomStatus(1);
		roomService.updateRoom(room);
	}

	@Override
	public void rentRoom(int customerId, String roomId, User user) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer == null) {
			throw new CustomException("客户记录不存在.");
		}
		Room room = roomService.getRoomById(roomId);
		if (room == null) {
			throw new CustomException("客房不存在.");
		} else if (room.getStatus() != 0) {
			throw new CustomException("客房不可用.");
		}
		// 创建授权码
		Authorization authorization = new Authorization();
		authorization.setCustomerId(customer.getCustomerId());// 客户ID
		authorization.setTypes(room.getTypes());
		authorization.setDeviceId(room.getRoomId());// 终端标识
		authorization.setStatus(0);
		authorization.setCreatedBy(user.getUserId());
		authorization.setCreatedDateNow();
		authorization.setUpdatedBy(user.getUserId());
		authorization.setUpdatedDateNow();
		authorizationService.addAuthorization(authorization);
		// 基础消费
		this.consumption(authorization.getAuthorizationId(),room.getTypes());
		// 更新房间状态
		room.setRoomStatus(1);
		roomService.updateRoom(room);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jing.settlement.service.MyCustomerService#rentStrap(java.lang.String,
	 * com.jing.system.user.entity.User)
	 */
	@Override
	public void rentStrap(String strapId, User user) {
		Strap strap = strapService.getStrapById(strapId);
		if (strap == null) {
			throw new CustomException("手牌不存在.");
		} else if (strap.getStatus() != 0) {
			throw new CustomException("手牌不可用.");
		}
		// 创建客户
		Customer customer = new Customer();
		customer.setCustomerName("客"+strap.getStrapNo());
		customer.setNote(strap.getStrapNo());
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);

		// 创建授权码
		Authorization authorization = new Authorization();
		authorization.setCustomerId(customer.getCustomerId());// 客户ID
		authorization.setTypes(strap.getTypes());
		authorization.setDeviceId(strapId);// 终端标识
		authorization.setStatus(0);
		authorization.setCreatedBy(user.getUserId());
		authorization.setCreatedDateNow();
		authorization.setUpdatedBy(user.getUserId());
		authorization.setUpdatedDateNow();
		authorizationService.addAuthorization(authorization);
		// 基础消费
		this.consumption(authorization.getAuthorizationId(),strap.getTypes());
		// 更新手牌状态
		strap.setStatus(1);
		strapService.updateStrap(strap);
	}

	@Override
	public void rentStrap(int customerId, String strapId, User user) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer == null) {
			throw new CustomException("客户记录不存在.");
		}
		Strap strap = strapService.getStrapById(strapId);
		if (strap == null) {
			throw new CustomException("手牌不存在.");
		} else if (strap.getStatus() != 0) {
			throw new CustomException("手牌不可用.");
		}
		// 创建授权码
		Authorization authorization = new Authorization();
		authorization.setCustomerId(customer.getCustomerId());// 客户ID
		authorization.setTypes(strap.getTypes());
		authorization.setDeviceId(strapId);// 终端标识
		authorization.setStatus(0);
		authorization.setCreatedBy(user.getUserId());
		authorization.setCreatedDateNow();
		authorization.setUpdatedBy(user.getUserId());
		authorization.setUpdatedDateNow();
		authorizationService.addAuthorization(authorization);
		// 基础消费
		this.consumption(authorization.getAuthorizationId(),strap.getTypes());
		// 更新手牌状态
		strap.setStatus(1);
		strapService.updateStrap(strap);
	}

	@Override
	public void cancelAuthorization(String authorizationId, User user) {
		// 查询授权码
		Authorization authorization = authorizationService.getAuthorizationById(authorizationId);
		if (authorization == null) {
			throw new CustomException("授权记录不存在.");
		}
		// 查询交易记录,如果有交易，则不允许取消

		Customer customer = customerService.getCustomerById(authorization.getCustomerId());
		if (customer == null) {
			throw new CustomException("客户记录不存在.");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customerId", authorization.getCustomerId());
		List<Authorization> authorizations = authorizationService.findAuthorizationList(param);
		// 如果只有一个授权，则取消客户
		if (authorizations != null && authorizations.size() == 1) {
			customer.setNote("取消");
			customer.setStatus(2);// 取消
			customerService.updateCustomer(customer);
		}

		// 释放房间或者手牌
		if (authorization.getTypes().intValue() == 0) {
			Room room = new Room();
			room.setRoomId(authorization.getDeviceId());
			room.setStatus(0);
			roomService.updateRoom(room);
		} else if (authorization.getTypes().intValue() == 1) {
			Strap strap = new Strap();
			strap.setStrapId(authorization.getDeviceId());
			strap.setStatus(0);
			strapService.updateStrap(strap);
		}

		// 设置授权码失效
		authorization.setStatus(2);// 失效
		authorizationService.updateAuthorization(authorization);
	}

	@Override
	public List<Authorization> findAuthorizations(String deviceId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("deviceId", deviceId);
		param.put("status", 0);
		List<Authorization> authorizations = authorizationService.findAuthorizationList(param);
		if (authorizations == null || authorizations.size() == 0) {
			throw new CustomException("无有效授权记录.");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerId", authorizations.get(0).getCustomerId());
		List<Authorization> res = authorizationService.findAuthorizationList(map);
		return res;
	}

	/**
	 * 产生基础消费记录
	 * @param typeId
	 */
	@Async
	public void consumption(String authorizationId ,int typeId) {
		// 查询types
		Types types = typesService.getTypesById(typeId);
		if(types ==null) {
			throw new CustomException("错误的消费类型");
		}
		List<TypesBind> binds = types.getBinds();
		if (binds != null && binds.size() > 0) {
			// 添加消费记录
			for (TypesBind typesBind : binds) {
				myTradeService.trade(authorizationId, typesBind.getObjectId(), typesBind.getObjectCt());
			}
		}
	}

}
