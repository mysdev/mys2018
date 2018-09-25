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
import com.jing.core.model.entity.MemberIntegralRecord;
import com.jing.core.service.MemberIntegralRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>会员积分流水 WEB接口<br>
 * <br>
 */
@Api("会员积分流水")
@Controller
@RequestMapping("/core/memberIntegralRecord")
public class MemberIntegralRecordController extends BaseController{

	@Autowired
	private MemberIntegralRecordService memberIntegralRecordService;
	
	@ApiOperation(value = "新增会员积分流水", notes = "添加会员积分流水")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(MemberIntegralRecord memberIntegralRecord,@SessionAttr(Config.USER_INFO) User user) {
		memberIntegralRecord.setCreatedBy(user.getUserId());
		memberIntegralRecord.setCreatedDateNow();
		memberIntegralRecord.setUpdatedBy(user.getUserId());
		memberIntegralRecord.setUpdatedDateNow();
		memberIntegralRecordService.addMemberIntegralRecord(memberIntegralRecord);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改会员积分流水", notes = "修改会员积分流水")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(MemberIntegralRecord memberIntegralRecord,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(memberIntegralRecord==null || memberIntegralRecord.getRecordId()==null){
			throw new CustomException("缺失修改参数.");
		}
		memberIntegralRecord.setUpdatedBy(user.getUserId());
		memberIntegralRecord.setUpdatedDateNow();
		memberIntegralRecordService.updateMemberIntegralRecord(memberIntegralRecord);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除会员积分流水", notes = "根据ID删除会员积分流水")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null){
			throw new CustomException("缺失删除参数.");
		}
		memberIntegralRecordService.deleteMemberIntegralRecordById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询会员积分流水", notes = "根据ID查询会员积分流水")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(memberIntegralRecordService.getMemberIntegralRecordById(id));
	}
		
	@ApiOperation(value = "分页查询会员积分流水", notes = "分页查询会员积分流水")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return memberIntegralRecordService.findMemberIntegralRecordListPage(PageRequestUtils.getPageBean(request), map);
	}
}