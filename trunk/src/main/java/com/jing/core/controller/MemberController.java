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
import com.jing.core.model.entity.Member;
import com.jing.core.service.MemberService;

import io.swagger.annotations.ApiOperation;

/**
 * <br>
 * <b>功能：</b>会员 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/core/member")
public class MemberController extends BaseController{

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value = "新增会员", notes = "添加会员")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Member member,@SessionAttr(Config.USER_INFO) User user) {
		member.setCreatedBy(user.getUserId());
		member.setCreatedDateNow();
		member.setUpdatedBy(user.getUserId());
		member.setUpdatedDateNow();
		memberService.addMember(member);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改会员", notes = "修改会员")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Member member,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(member==null || member.getMemberId()==null || "".equals(member.getMemberId())){
			throw new CustomException("缺失修改参数.");
		}
		member.setUpdatedBy(user.getUserId());
		member.setUpdatedDateNow();
		memberService.updateMember(member);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除会员", notes = "根据ID删除会员")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		memberService.deleteMemberById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询会员", notes = "根据ID查询会员")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(memberService.getMemberById(id));
	}
		
	@ApiOperation(value = "分页查询会员", notes = "分页查询会员")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return memberService.findMemberListPage(PageRequestUtils.getPageBean(request), map);
	}
}