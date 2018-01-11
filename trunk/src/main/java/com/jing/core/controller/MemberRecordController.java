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
import com.jing.core.model.entity.MemberRecord;
import com.jing.core.service.MemberRecordService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: MemberRecordController
 * @Description: 会员充值记录HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="会员充值记录")
public class MemberRecordController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private MemberRecordService memberRecordService;

	
	@ApiOperation(value = "新增 添加会员充值记录信息", notes = "添加会员充值记录信息")
	@RequestMapping(value = "/memberrecord", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addMemberRecord(HttpServletResponse response,
			@ApiParam(value = "memberRecord") @RequestBody MemberRecord memberRecord) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberRecord, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		memberRecord.setRecordId(null);
		memberRecordService.addMemberRecord(memberRecord);
		return memberRecord;
	}
	
	
	@ApiOperation(value = "更新 根据会员充值记录标识更新会员充值记录信息", notes = "根据会员充值记录标识更新会员充值记录信息")
	@RequestMapping(value = "/memberrecord/{recordId:.+}", method = RequestMethod.PUT)
	public Object modifyMemberRecordById(HttpServletResponse response,
			@PathVariable Integer recordId,
			@ApiParam(value = "memberRecord", required = true) @RequestBody MemberRecord memberRecord
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberRecord, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		MemberRecord tempMemberRecord = memberRecordService.queryMemberRecordByRecordId(recordId);
		memberRecord.setRecordId(recordId);
		if(null == tempMemberRecord){
			throw new NotFoundException("会员充值记录");
		}
		return memberRecordService.modifyMemberRecord(memberRecord);
	}

	@ApiOperation(value = "删除 根据会员充值记录标识删除会员充值记录信息", notes = "根据会员充值记录标识删除会员充值记录信息")
	@RequestMapping(value = "/memberrecord/{recordId:.+}", method = RequestMethod.DELETE)
	public Object dropMemberRecordByRecordId(HttpServletResponse response, @PathVariable Integer recordId) {
		MemberRecord memberRecord = memberRecordService.queryMemberRecordByRecordId(recordId);
		if(null == memberRecord){
			throw new NotFoundException("会员充值记录");
		}
		return memberRecordService.dropMemberRecordByRecordId(recordId);
	}
	
	@ApiOperation(value = "查询 根据会员充值记录标识查询会员充值记录信息", notes = "根据会员充值记录标识查询会员充值记录信息")
	@RequestMapping(value = "/memberrecord/{recordId:.+}", method = RequestMethod.GET)
	public Object queryMemberRecordById(HttpServletResponse response,
			@PathVariable Integer recordId) {
		MemberRecord memberRecord = memberRecordService.queryMemberRecordByRecordId(recordId);
		if(null == memberRecord){
			throw new NotFoundException("会员充值记录");
		}
		return memberRecord;
	}
	
	@ApiOperation(value = "查询 根据会员充值记录属性查询会员充值记录信息列表", notes = "根据会员充值记录属性查询会员充值记录信息列表")
	@RequestMapping(value = "/memberrecord", method = RequestMethod.GET)
	public Object queryMemberRecordList(HttpServletResponse response,
			MemberRecord memberRecord) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return memberRecordService.queryMemberRecordByProperty(ClassUtil.transBean2Map(memberRecord, false));
	}
	
	@ApiOperation(value = "查询分页 根据会员充值记录属性分页查询会员充值记录信息列表", notes = "根据会员充值记录属性分页查询会员充值记录信息列表")
	@RequestMapping(value = "/memberrecords", method = RequestMethod.GET)
	public Object queryMemberRecordPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, MemberRecord memberRecord) {				
		return memberRecordService.queryMemberRecordForPage(pagenum, pagesize, sort, memberRecord);
	}

}
