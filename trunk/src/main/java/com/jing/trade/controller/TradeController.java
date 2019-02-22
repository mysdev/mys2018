package com.jing.trade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.service.AuthorizationService;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.TradeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>消费清单 WEB接口<br>
 * <br>
 */
@Api("消费清单")
@Controller
@RequestMapping("/trade/trade")
public class TradeController extends BaseController{

	@Autowired
	private TradeService tradeService;
	@Autowired
	private AuthorizationService authorizationService;
	
	@ApiOperation(value = "新增消费清单", notes = "添加消费清单")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Trade trade,@SessionAttr(Config.USER_INFO) User user) {
		trade.setCreatedBy(user.getUserId());
		trade.setCreatedDateNow();
		trade.setUpdatedBy(user.getUserId());
		trade.setUpdatedDateNow();
		tradeService.addTrade(trade);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "新增消费清单", notes = "添加消费清单")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result doTrade(@RequestParam String did,Trade trade,@SessionAttr(Config.USER_INFO) User user) {
		//根据did找到授权码
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deviceId", did);
		map.put("status", "0");
		List<Authorization> list = authorizationService.findAuthorizationList(map);
		if(list==null || list.size()==0) {
			throw new CustomException("授权码不存在，无法消费.");
		}
		Authorization authorization = list.get(0);
		trade.setAuthorizationId(authorization.getAuthorizationId());
		trade.setCustomerId(authorization.getCustomerId());
		trade.setCreatedBy(user.getUserId());
		trade.setCreatedDateNow();
		trade.setUpdatedBy(user.getUserId());
		trade.setUpdatedDateNow();
		tradeService.addTrade(trade);
		return Result.getDefaultSuccMsgResult();
	}
	
	
	
	@ApiOperation(value = "修改消费清单", notes = "修改消费清单")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Trade trade,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(trade==null || trade.getTradeId()==null || "".equals(trade.getTradeId())){
			throw new CustomException("缺失修改参数.");
		}
		trade.setUpdatedBy(user.getUserId());
		trade.setUpdatedDateNow();
		tradeService.updateTrade(trade);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除消费清单", notes = "根据ID删除消费清单")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		tradeService.deleteTradeById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询消费清单", notes = "根据ID查询消费清单")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(tradeService.getTradeById(id));
	}
		
	@ApiOperation(value = "分页查询消费清单", notes = "分页查询消费清单")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		if(map.get("rid") !=null) {
			return tradeService.findTradeByRidListPage(PageRequestUtils.getPageBean(request), map);
		}else {
			return tradeService.findTradeListPage(PageRequestUtils.getPageBean(request), map);
		}
	}
}