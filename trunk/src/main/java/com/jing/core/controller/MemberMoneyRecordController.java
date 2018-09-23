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
import com.jing.core.model.entity.MemberMoneyRecord;
import com.jing.core.service.MemberMoneyRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>会员金额流水 WEB接口<br>
 * <br>
 */
@Api("会员金额流水")
@Controller
@RequestMapping("/core/memberMoneyRecord")
public class MemberMoneyRecordController extends BaseController{

	@Autowired
	private MemberMoneyRecordService memberMoneyRecordService;
	
	@ApiOperation(value = "新增会员金额流水", notes = "添加会员金额流水")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(MemberMoneyRecord memberMoneyRecord,@SessionAttr(Config.USER_INFO) User user) {
		memberMoneyRecord.setCreatedBy(user.getUserId());
		memberMoneyRecord.setCreatedDateNow();
		memberMoneyRecord.setUpdatedBy(user.getUserId());
		memberMoneyRecord.setUpdatedDateNow();
		memberMoneyRecordService.addMemberMoneyRecord(memberMoneyRecord);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改会员金额流水", notes = "修改会员金额流水")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(MemberMoneyRecord memberMoneyRecord,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(memberMoneyRecord==null || memberMoneyRecord.getRecordId()==null || "".equals(memberMoneyRecord.getRecordId())){
			throw new CustomException("缺失修改参数.");
		}
		memberMoneyRecord.setUpdatedBy(user.getUserId());
		memberMoneyRecord.setUpdatedDateNow();
		memberMoneyRecordService.updateMemberMoneyRecord(memberMoneyRecord);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除会员金额流水", notes = "根据ID删除会员金额流水")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		memberMoneyRecordService.deleteMemberMoneyRecordById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询会员金额流水", notes = "根据ID查询会员金额流水")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(memberMoneyRecordService.getMemberMoneyRecordById(id));
	}
		
	@ApiOperation(value = "分页查询会员金额流水", notes = "分页查询会员金额流水")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return memberMoneyRecordService.findMemberMoneyRecordListPage(PageRequestUtils.getPageBean(request), map);
	}
}