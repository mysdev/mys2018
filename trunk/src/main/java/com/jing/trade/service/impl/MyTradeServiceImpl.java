package com.jing.trade.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.core.service.MyMemberService;
import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.model.entity.Goods;
import com.jing.settlement.service.AuthorizationService;
import com.jing.settlement.service.CustomerService;
import com.jing.settlement.service.GoodsService;
import com.jing.system.user.entity.User;
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.MyTradeService;
import com.jing.trade.service.TradeService;
import com.jing.utils.PrimaryKey;

@Service("myTradeService")
public class MyTradeServiceImpl implements MyTradeService{
	@Autowired
	private TradeService tradeService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MyMemberService myMemberService;
	
	

	@Override
	public void trade(String authorizationId, String goodsId, int ct) {
		Authorization authorization = authorizationService.getAuthorizationById(authorizationId);
		if(authorization==null) {
			throw new CustomException("授权信息不存在.");
		}
		Customer customer = customerService.getCustomerById(authorization.getCustomerId());
		if(customer==null) {
			throw new CustomException("客户信息不存在.");
		}
		Goods goods = this.goodsService.getGoodsById(goodsId);
		if(goods==null) {
			throw new CustomException("商品/服务不存在.");
		}
		Trade trade = new Trade();
		trade.setSerialNumber(PrimaryKey.getEventNo());
		trade.setCustomerId(authorization.getCustomerId());//客户ID
		trade.setCustomerCt(customer.getCt());
		trade.setAuthorizationId(authorizationId);//授权码
		trade.setObjectId(goodsId);//物品
		trade.setObjectCt(ct);//数量
		trade.setStatus(0);
		trade.setMarkedPrice(goods.getPrice());
		tradeService.addTrade(trade);
	}
	
	
	/**
	 * 结算
	 */
	public void bill(String[] authorizationIdArry) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("authorizationIdArry", authorizationIdArry);
		List<Trade> tradeList = tradeService.findTradeList(param);
		if(tradeList==null || tradeList.size()==0) {
			throw new CustomException("无消费记录");
		}
		//返回的对象里面应该包含：商品服务，套餐信息，原价、优惠价、
		
	}
	
	/**
	 * 支付
	 * @param authorizationIdArry 授权码
	 * @param payType (现金或者会员余额)
	 * @param amount （收银）
	 * @param empId (会员ID）
	 * @param memberId (员工ID)
	 * @param reliefAmount (授权额)
	 */
	public void pay(String[] authorizationIdArry, int payType, float amount,String empId,String memberId,String reliefAmount,User user) {
		BigDecimal sum = null;//原价(账单总额 = (商品原价 - 商品优惠价)*商品数量)
		BigDecimal sAmount = null;//应付 = 原价sum - 授权额reliefAmount		
		BigDecimal memberAmount = null;//扣余额数  = 应付sAmount - 已付amount
		
		myMemberService.pay(memberId, memberAmount.floatValue(),"支付",user);
	}

}
