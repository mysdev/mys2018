package com.jing.trade.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.trade.model.entity.Settlement;
import com.jing.trade.service.SettlementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>消费结算 WEB接口<br>
 * <br>
 */
@Api("消费结算")
@Controller
@RequestMapping("/trade/settlement")
public class SettlementController extends BaseController{

	@Autowired
	private SettlementService settlementService;
	
	@ApiOperation(value = "新增消费结算", notes = "添加消费结算")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Settlement settlement,@SessionAttr(Config.USER_INFO) User user) {
		settlement.setCreatedBy(user.getUserId());
		settlement.setCreatedDateNow();
		settlement.setUpdatedBy(user.getUserId());
		settlement.setUpdatedDateNow();
		settlementService.addSettlement(settlement);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改消费结算", notes = "修改消费结算")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Settlement settlement,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(settlement==null || settlement.getSettlementId()==null || "".equals(settlement.getSettlementId())){
			throw new CustomException("缺失修改参数.");
		}
		settlement.setUpdatedBy(user.getUserId());
		settlement.setUpdatedDateNow();
		settlementService.updateSettlement(settlement);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除消费结算", notes = "根据ID删除消费结算")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		settlementService.deleteSettlementById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询消费结算", notes = "根据ID查询消费结算")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(settlementService.getSettlementById(id));
	}
		
	@ApiOperation(value = "分页查询消费结算", notes = "分页查询消费结算")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return settlementService.findSettlementListPage(PageRequestUtils.getPageBean(request), map);
	}
}