package com.jing.core.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.core.model.entity.Member;
import com.jing.core.service.MemberService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: MemberController
 * @Description: 会员HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="会员", tags={"CoreMember"})
public class MemberController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private MemberService memberService;

	
	@ApiOperation(value = "新增 添加会员信息", notes = "添加会员信息")
	@RequestMapping(value = "/member", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addMember(HttpServletResponse response,
			@ApiParam(value = "member") @RequestBody Member member) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(member, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		member.setMemberId(null);
		memberService.addMember(member);
		return member;
	}
	
	
	@ApiOperation(value = "更新 根据会员标识更新会员信息", notes = "根据会员标识更新会员信息")
	@RequestMapping(value = "/member/{memberId:.+}", method = RequestMethod.PUT)
	public Object modifyMemberById(HttpServletResponse response,
			@PathVariable String memberId,
			@ApiParam(value = "member", required = true) @RequestBody Member member
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(member, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Member tempMember = memberService.queryMemberByMemberId(memberId);
		member.setMemberId(memberId);
		if(null == tempMember){
			throw new NotFoundException("会员");
		}
		return memberService.modifyMember(member);
	}

	@ApiOperation(value = "删除 根据会员标识删除会员信息", notes = "根据会员标识删除会员信息")
	@RequestMapping(value = "/member/{memberId:.+}", method = RequestMethod.DELETE)
	public Object dropMemberByMemberId(HttpServletResponse response, @PathVariable String memberId) {
		Member member = memberService.queryMemberByMemberId(memberId);
		if(null == member){
			throw new NotFoundException("会员");
		}
		return memberService.dropMemberByMemberId(memberId);
	}
	
	@ApiOperation(value = "查询 根据会员标识查询会员信息", notes = "根据会员标识查询会员信息")
	@RequestMapping(value = "/member/{memberId:.+}", method = RequestMethod.GET)
	public Object queryMemberById(HttpServletResponse response,
			@PathVariable String memberId) {
		Member member = memberService.queryMemberByMemberId(memberId);
		if(null == member){
			throw new NotFoundException("会员");
		}
		return member;
	}
	
	@ApiOperation(value = "查询 根据会员属性查询会员信息列表", notes = "根据会员属性查询会员信息列表")
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public Object queryMemberList(HttpServletResponse response,
			Member member) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return memberService.queryMemberByProperty(ClassUtil.transBean2Map(member, false));
	}
	
	@ApiOperation(value = "查询分页 根据会员属性分页查询会员信息列表", notes = "根据会员属性分页查询会员信息列表")
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public Object queryMemberPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Member member) {				
		return memberService.queryMemberForPage(pagenum, pagesize, sort, member);
	}
	
	/**
	 * 会员充值
	 * @param memberId
	 * @param amount
	 * @return
	 */
	@ApiOperation(value = "会员充值", notes = "会员充值")
	@RequestMapping(value = "/member/recharge", method = RequestMethod.POST)
	public Object recharge(@RequestParam String memberId,@RequestParam Integer amount) {
		return memberService.recharge(memberId, amount);
		
	}
	
	@ApiOperation(value = "查询 根据会员标识查询会员信息", notes = "根据会员标识查询会员信息")
	@RequestMapping(value = "/member/cardNo/{memberId:.+}", method = RequestMethod.GET)
	public Object findMemberByCard(HttpServletResponse response,
			@PathVariable String cardNo) {
		Member member = memberService.findMemberByCard(cardNo);
		if(null == member){
			throw new NotFoundException("会员");
		}
		return member;
	}

}
