package com.jing.core.controller;

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
import com.jing.core.model.entity.MemberPlus;
import com.jing.core.service.MemberPlusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>会员充值活动 WEB接口<br>
 * <br>
 */
@Api("会员充值活动")
@Controller
@RequestMapping("/core/memberPlus")
public class MemberPlusController extends BaseController{

	@Autowired
	private MemberPlusService memberPlusService;
	
	@ApiOperation(value = "新增会员充值活动", notes = "添加会员充值活动")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(MemberPlus memberPlus,@SessionAttr(Config.USER_INFO) User user) {
		memberPlus.setCreatedBy(user.getUserId());
		memberPlus.setCreatedDateNow();
		memberPlus.setUpdatedBy(user.getUserId());
		memberPlus.setUpdatedDateNow();
		memberPlusService.addMemberPlus(memberPlus);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改会员充值活动", notes = "修改会员充值活动")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(MemberPlus memberPlus,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(memberPlus==null || memberPlus.getPlusId()==null || "".equals(memberPlus.getPlusId())){
			throw new CustomException("缺失修改参数.");
		}
		memberPlus.setUpdatedBy(user.getUserId());
		memberPlus.setUpdatedDateNow();
		memberPlusService.updateMemberPlus(memberPlus);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除会员充值活动", notes = "根据ID删除会员充值活动")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		memberPlusService.deleteMemberPlusById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询会员充值活动", notes = "根据ID查询会员充值活动")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(memberPlusService.getMemberPlusById(id));
	}
		
	@ApiOperation(value = "分页查询会员充值活动", notes = "分页查询会员充值活动")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return memberPlusService.findMemberPlusListPage(PageRequestUtils.getPageBean(request), map);
	}
}