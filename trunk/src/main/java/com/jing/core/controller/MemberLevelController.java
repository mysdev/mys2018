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
import com.jing.core.model.entity.MemberLevel;
import com.jing.core.service.MemberLevelService;
import com.jing.core.util.MemberLevelCache;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>会员体系 WEB接口<br>
 * <br>
 */
@Api("会员体系")
@Controller
@RequestMapping("/core/memberLevel")
public class MemberLevelController extends BaseController{

	@Autowired
	private MemberLevelService memberLevelService;
	
	@ApiOperation(value = "新增会员体系", notes = "添加会员体系")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(MemberLevel memberLevel,@SessionAttr(Config.USER_INFO) User user) {
		memberLevel.setCreatedBy(user.getUserId());
		memberLevel.setCreatedDateNow();
		memberLevel.setUpdatedBy(user.getUserId());
		memberLevel.setUpdatedDateNow();
		memberLevelService.addMemberLevel(memberLevel);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改会员体系", notes = "修改会员体系")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(MemberLevel memberLevel,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(memberLevel==null || memberLevel.getLevelId()==null || "".equals(memberLevel.getLevelId())){
			throw new CustomException("缺失修改参数.");
		}
		memberLevel.setUpdatedBy(user.getUserId());
		memberLevel.setUpdatedDateNow();
		memberLevelService.updateMemberLevel(memberLevel);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除会员体系", notes = "根据ID删除会员体系")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") Integer id){
		if(id==null){
			throw new CustomException("缺失删除参数.");
		}
		memberLevelService.deleteMemberLevelById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询会员体系", notes = "根据ID查询会员体系")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null ){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(memberLevelService.getMemberLevelById(id));
	}
	
	@ApiOperation(value = "查询会员体系", notes = "查询会员体系")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Result all(){
		return Result.getDefaultSuccMsgResult(MemberLevelCache.getAll());
	}
		
	@ApiOperation(value = "分页查询会员体系", notes = "分页查询会员体系")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return memberLevelService.findMemberLevelListPage(PageRequestUtils.getPageBean(request), map);
	}
}