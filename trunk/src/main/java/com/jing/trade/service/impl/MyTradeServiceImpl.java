package com.jing.trade.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.jing.settlement.model.entity.Merchandise;
import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.service.AuthorizationService;
import com.jing.settlement.service.CustomerService;
import com.jing.settlement.service.GoodsService;
import com.jing.settlement.service.PackagesService;
import com.jing.system.user.entity.User;
import com.jing.trade.model.entity.Bill;
import com.jing.trade.model.entity.Settlement;
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.MyTradeService;
import com.jing.trade.service.SettlementService;
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
	@Autowired
	private PackagesService packagesService;
	@Autowired
	private SettlementService settlementService;
	

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
	public Bill bill(String[] authorizationIdArry) {
		//返回的对象里面应该包含：商品服务，套餐信息，原价、优惠价、
		return conversion(authorizationIdArry);
	}
	
	private Bill conversion(String[] authorizationIdArry) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("authorizationIdArry", authorizationIdArry);
		List<Trade> tradeList = tradeService.findTradeList(param);
		if(tradeList==null || tradeList.size()==0) {
			throw new CustomException("无消费记录");
		}
		List<Merchandise> merchandises = this.merchandise(tradeList);
		BigDecimal total = new BigDecimal(0);//应付
		BigDecimal original = new BigDecimal(0);//原价		
		for (Merchandise merchandise : merchandises) {
			total = total.add(merchandise.getTotalPrice());
			original = original.add(merchandise.getOriginalPrice().multiply(new BigDecimal(merchandise.getQuantity())));
		}
		BigDecimal preferential = original.subtract(total);
		Bill bill = new Bill();
		bill.setMerchandises(merchandises);
		bill.setTotal(total);
		bill.setOriginal(original);
		bill.setPreferential(preferential);
		return bill;
	}
	
	/**
	 * 整理消费情况
	 * @param tradeList
	 * @return
	 */
	private List<Merchandise> merchandise(List<Trade> tradeList){
		Map<String, Merchandise> tmap = new HashMap<String, Merchandise>();
		for (Trade trade : tradeList) {
			String gpId = trade.getObjectId();
			Merchandise merchandise = tmap.get(gpId);
			if(tmap.get(gpId) == null) {
				merchandise = new Merchandise();
				merchandise.setGspType(trade.getObjectType());
				merchandise.setGpId(gpId);
				if(trade.getObjectType().intValue()==1) {
					Goods goods = goodsService.getGoodsById(gpId);
					if(goods==null) {
						throw new CustomException("交易数据错误，存在无效商品ID["+gpId+"]");
					}
					merchandise.setName(goods.getGoodsName());
				}
				merchandise.setQuantity(merchandise.getQuantity() +  trade.getObjectCt().intValue());
				tmap.put(gpId,merchandise);
			}
		}
		List<Merchandise> mlist = new ArrayList<Merchandise>(tmap.values());//消费清单
		List<Packages> plist = findPackages();//系统中的套餐
		List<Merchandise> mypackages =  new ArrayList<Merchandise>();//套餐消费情况 
		if(plist!=null && plist.size()>0) {
			for (Packages packages : plist) {
				List<PackagesDetail> packagesDetails = packages.getPackagesDetails(); 
				if(packagesDetails==null || packagesDetails.size()==0) {
					throw new CustomException("套餐数据错误，存在无效套餐ID["+packages.getPackageId()+"]");
				}
				boolean t = this.checkPackages(mlist, packagesDetails);
				if(t) {
					Merchandise myMerchandise = new Merchandise();
					myMerchandise.setName(packages.getPackageName());
					myMerchandise.setGpId(packages.getPackageId());
					myMerchandise.setGspType(3);//类型为套餐
					myMerchandise.setOriginalPrice(packages.getOriginalPrice());
					myMerchandise.setPrice(packages.getPrice());
					addMerchandise(myMerchandise, mypackages);//累加套餐数量
					//从交易里面减少商品
					for (PackagesDetail packagesDetail : packagesDetails) {
						for(int i=0;i<mlist.size();i++) {
							Merchandise merchandise = mlist.get(i);
							int ct = merchandise.getQuantity() - packagesDetail.getGoodsCt().intValue();//数量
							if(ct>=0) {
								//如果清单中扣除套餐还有余量，则设置余量
								merchandise.setQuantity(ct);
							}else {
								//如果清单中扣除套餐后没有余量，则删除单个商品消费
								mlist.remove(i);
							}
						}
					}
				}
			}
		}
		mlist.addAll(mypackages);
		return mlist;
	}
	
	/**
	 * 累加套餐数量[同一套餐多次消费]
	 * @param myMerchandise
	 * @param mypackages
	 */
	private void addMerchandise(Merchandise myMerchandise,List<Merchandise> mypackages) {
		for (Merchandise merchandise : mypackages) {
			if(merchandise.getGpId().equals(myMerchandise.getGpId())) {
				merchandise.setQuantity(merchandise.getQuantity()+1);
				return ;
			}
		}
		myMerchandise.setQuantity(1);
		mypackages.add(myMerchandise);
	}
	
	/**
	 * 是否可以构成套餐
	 * @param mlist
	 * @param pdlist
	 * @return
	 */
	private boolean checkPackages(List<Merchandise> mlist,List<PackagesDetail> pdlist) {
		int i =0;
		for (PackagesDetail packagesDetail : pdlist) {
			for (Merchandise m : mlist) {
				if(m.getGpId().equals(packagesDetail.getGoodsId()) && m.getQuantity() >= packagesDetail.getGoodsCt().intValue()) {
					i++;
				}
			}
		}
		if(i<=pdlist.size()) {
			return false;//没有全部找到
		}else {
			return true;
		}
	}
	
	/**
	 * 查询状态正常的套餐
	 * @return
	 */
	private List<Packages> findPackages(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", "0");
		List<Packages> list = packagesService.findPackagesList(param);
		return list;
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
	public Settlement pay(String[] authorizationIdArry, int payType, int amount,String empId,String memberId,int reliefAmount,User user) {
		Bill bill = this.bill(authorizationIdArry);
		BigDecimal sum = bill.getTotal();//原价(账单总额 = (商品原价 - 商品优惠价)*商品数量)
		BigDecimal sAmount = sum.subtract(new BigDecimal(reliefAmount));//应付 = 原价sum - 授权额reliefAmount		
		BigDecimal memberAmount = sAmount.subtract(new BigDecimal(amount));//扣余额数  = 应付sAmount - 已付amount
		//会员余额支付
		myMemberService.pay(memberId, memberAmount.floatValue(),"支付",user);
		Settlement settlement = new Settlement();//保存结算清单
		settlement.setEmpId(empId);
		settlement.setMemberId(memberId);
		settlement.setDealPrice(sAmount);//实付金额
		settlement.setSettlementTime(new Date());
		settlement.setMarkedPrice(bill.getOriginal());
		settlement.setDiscountPrice(bill.getPreferential());
//		settlement.setReductionPrice(reductionPrice);//折扣
		settlement.setExchangeId(payType);//支付方式
		settlement.setPayPrice(sAmount);
		settlement.setCreatedBy(user.getUserId());
		settlement.setUpdatedBy(user.getUserId());
		settlement.setCreatedDateNow();
		settlement.setUpdatedDateNow();
		settlementService.addSettlement(settlement);
		return settlement;
	}

}
