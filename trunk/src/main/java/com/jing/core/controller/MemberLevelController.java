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
import com.jing.core.model.entity.MemberLevel;
import com.jing.core.service.MemberLevelService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: MemberLevelController
 * @Description: 会员体系HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="会员体系", tags={"CoreMemberLevel"})
public class MemberLevelController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private MemberLevelService memberLevelService;

	
	@ApiOperation(value = "新增 添加会员体系信息", notes = "添加会员体系信息")
	@RequestMapping(value = "/memberlevel", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addMemberLevel(HttpServletResponse response,
			@ApiParam(value = "memberLevel") @RequestBody MemberLevel memberLevel) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberLevel, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		memberLevel.setLevelId(null);
		memberLevelService.addMemberLevel(memberLevel);
		return memberLevel;
	}
	
	
	@ApiOperation(value = "更新 根据会员体系标识更新会员体系信息", notes = "根据会员体系标识更新会员体系信息")
	@RequestMapping(value = "/memberlevel/{levelId:.+}", method = RequestMethod.PUT)
	public Object modifyMemberLevelById(HttpServletResponse response,
			@PathVariable Integer levelId,
			@ApiParam(value = "memberLevel", required = true) @RequestBody MemberLevel memberLevel
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberLevel, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		MemberLevel tempMemberLevel = memberLevelService.queryMemberLevelByLevelId(levelId);
		memberLevel.setLevelId(levelId);
		if(null == tempMemberLevel){
			throw new NotFoundException("会员体系");
		}
		return memberLevelService.modifyMemberLevel(memberLevel);
	}

	@ApiOperation(value = "删除 根据会员体系标识删除会员体系信息", notes = "根据会员体系标识删除会员体系信息")
	@RequestMapping(value = "/memberlevel/{levelId:.+}", method = RequestMethod.DELETE)
	public Object dropMemberLevelByLevelId(HttpServletResponse response, @PathVariable Integer levelId) {
		MemberLevel memberLevel = memberLevelService.queryMemberLevelByLevelId(levelId);
		if(null == memberLevel){
			throw new NotFoundException("会员体系");
		}
		return memberLevelService.dropMemberLevelByLevelId(levelId);
	}
	
	@ApiOperation(value = "查询 根据会员体系标识查询会员体系信息", notes = "根据会员体系标识查询会员体系信息")
	@RequestMapping(value = "/memberlevel/{levelId:.+}", method = RequestMethod.GET)
	public Object queryMemberLevelById(HttpServletResponse response,
			@PathVariable Integer levelId) {
		MemberLevel memberLevel = memberLevelService.queryMemberLevelByLevelId(levelId);
		if(null == memberLevel){
			throw new NotFoundException("会员体系");
		}
		return memberLevel;
	}
	
	@ApiOperation(value = "查询 根据会员体系属性查询会员体系信息列表", notes = "根据会员体系属性查询会员体系信息列表")
	@RequestMapping(value = "/memberlevel", method = RequestMethod.GET)
	public Object queryMemberLevelList(HttpServletResponse response,
			MemberLevel memberLevel) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return memberLevelService.queryMemberLevelByProperty(ClassUtil.transBean2Map(memberLevel, false));
	}
	
	@ApiOperation(value = "查询分页 根据会员体系属性分页查询会员体系信息列表", notes = "根据会员体系属性分页查询会员体系信息列表")
	@RequestMapping(value = "/memberlevels", method = RequestMethod.GET)
	public Object queryMemberLevelPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, MemberLevel memberLevel) {				
		return memberLevelService.queryMemberLevelForPage(pagenum, pagesize, sort, memberLevel);
	}

}
