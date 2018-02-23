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
import com.jing.core.model.entity.MemberPlus;
import com.jing.core.service.MemberPlusService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: MemberPlusController
 * @Description: 会员充值活动HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="会员充值活动", tags={"CoreMemberPlus"})
public class MemberPlusController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private MemberPlusService memberPlusService;

	
	@ApiOperation(value = "新增 添加会员充值活动信息", notes = "添加会员充值活动信息")
	@RequestMapping(value = "/memberplus", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addMemberPlus(HttpServletResponse response,
			@ApiParam(value = "memberPlus") @RequestBody MemberPlus memberPlus) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberPlus, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		memberPlus.setPlusId(null);
		memberPlusService.addMemberPlus(memberPlus);
		return memberPlus;
	}
	
	
	@ApiOperation(value = "更新 根据会员充值活动标识更新会员充值活动信息", notes = "根据会员充值活动标识更新会员充值活动信息")
	@RequestMapping(value = "/memberplus/{plusId:.+}", method = RequestMethod.PUT)
	public Object modifyMemberPlusById(HttpServletResponse response,
			@PathVariable Integer plusId,
			@ApiParam(value = "memberPlus", required = true) @RequestBody MemberPlus memberPlus
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberPlus, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		MemberPlus tempMemberPlus = memberPlusService.queryMemberPlusByPlusId(plusId);
		memberPlus.setPlusId(plusId);
		if(null == tempMemberPlus){
			throw new NotFoundException("会员充值活动");
		}
		return memberPlusService.modifyMemberPlus(memberPlus);
	}

	@ApiOperation(value = "删除 根据会员充值活动标识删除会员充值活动信息", notes = "根据会员充值活动标识删除会员充值活动信息")
	@RequestMapping(value = "/memberplus/{plusId:.+}", method = RequestMethod.DELETE)
	public Object dropMemberPlusByPlusId(HttpServletResponse response, @PathVariable Integer plusId) {
		MemberPlus memberPlus = memberPlusService.queryMemberPlusByPlusId(plusId);
		if(null == memberPlus){
			throw new NotFoundException("会员充值活动");
		}
		return memberPlusService.dropMemberPlusByPlusId(plusId);
	}
	
	@ApiOperation(value = "查询 根据会员充值活动标识查询会员充值活动信息", notes = "根据会员充值活动标识查询会员充值活动信息")
	@RequestMapping(value = "/memberplus/{plusId:.+}", method = RequestMethod.GET)
	public Object queryMemberPlusById(HttpServletResponse response,
			@PathVariable Integer plusId) {
		MemberPlus memberPlus = memberPlusService.queryMemberPlusByPlusId(plusId);
		if(null == memberPlus){
			throw new NotFoundException("会员充值活动");
		}
		return memberPlus;
	}
	
	@ApiOperation(value = "查询 根据会员充值活动属性查询会员充值活动信息列表", notes = "根据会员充值活动属性查询会员充值活动信息列表")
	@RequestMapping(value = "/memberplus", method = RequestMethod.GET)
	public Object queryMemberPlusList(HttpServletResponse response,
			MemberPlus memberPlus) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return memberPlusService.queryMemberPlusByProperty(ClassUtil.transBean2Map(memberPlus, false));
	}
	
	@ApiOperation(value = "查询分页 根据会员充值活动属性分页查询会员充值活动信息列表", notes = "根据会员充值活动属性分页查询会员充值活动信息列表")
	@RequestMapping(value = "/memberpluss", method = RequestMethod.GET)
	public Object queryMemberPlusPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, MemberPlus memberPlus) {				
		return memberPlusService.queryMemberPlusForPage(pagenum, pagesize, sort, memberPlus);
	}

}
