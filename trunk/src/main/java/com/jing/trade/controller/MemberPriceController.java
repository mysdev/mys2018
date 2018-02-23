package com.jing.trade.controller;

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
import com.jing.trade.model.entity.MemberPrice;
import com.jing.trade.service.MemberPriceService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: MemberPriceController
 * @Description: 会员价格HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="会员价格", tags={"TradeMemberPrice"})
public class MemberPriceController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private MemberPriceService memberPriceService;

	
	@ApiOperation(value = "新增 添加会员价格信息", notes = "添加会员价格信息")
	@RequestMapping(value = "/memberprice", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addMemberPrice(HttpServletResponse response,
			@ApiParam(value = "memberPrice") @RequestBody MemberPrice memberPrice) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberPrice, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		memberPrice.setPriceId(null);
		memberPriceService.addMemberPrice(memberPrice);
		return memberPrice;
	}
	
	
	@ApiOperation(value = "更新 根据会员价格标识更新会员价格信息", notes = "根据会员价格标识更新会员价格信息")
	@RequestMapping(value = "/memberprice/{priceId:.+}", method = RequestMethod.PUT)
	public Object modifyMemberPriceById(HttpServletResponse response,
			@PathVariable Integer priceId,
			@ApiParam(value = "memberPrice", required = true) @RequestBody MemberPrice memberPrice
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(memberPrice, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		MemberPrice tempMemberPrice = memberPriceService.queryMemberPriceByPriceId(priceId);
		memberPrice.setPriceId(priceId);
		if(null == tempMemberPrice){
			throw new NotFoundException("会员价格");
		}
		return memberPriceService.modifyMemberPrice(memberPrice);
	}

	@ApiOperation(value = "删除 根据会员价格标识删除会员价格信息", notes = "根据会员价格标识删除会员价格信息")
	@RequestMapping(value = "/memberprice/{priceId:.+}", method = RequestMethod.DELETE)
	public Object dropMemberPriceByPriceId(HttpServletResponse response, @PathVariable Integer priceId) {
		MemberPrice memberPrice = memberPriceService.queryMemberPriceByPriceId(priceId);
		if(null == memberPrice){
			throw new NotFoundException("会员价格");
		}
		return memberPriceService.dropMemberPriceByPriceId(priceId);
	}
	
	@ApiOperation(value = "查询 根据会员价格标识查询会员价格信息", notes = "根据会员价格标识查询会员价格信息")
	@RequestMapping(value = "/memberprice/{priceId:.+}", method = RequestMethod.GET)
	public Object queryMemberPriceById(HttpServletResponse response,
			@PathVariable Integer priceId) {
		MemberPrice memberPrice = memberPriceService.queryMemberPriceByPriceId(priceId);
		if(null == memberPrice){
			throw new NotFoundException("会员价格");
		}
		return memberPrice;
	}
	
	@ApiOperation(value = "查询 根据会员价格属性查询会员价格信息列表", notes = "根据会员价格属性查询会员价格信息列表")
	@RequestMapping(value = "/memberprice", method = RequestMethod.GET)
	public Object queryMemberPriceList(HttpServletResponse response,
			MemberPrice memberPrice) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return memberPriceService.queryMemberPriceByProperty(ClassUtil.transBean2Map(memberPrice, false));
	}
	
	@ApiOperation(value = "查询分页 根据会员价格属性分页查询会员价格信息列表", notes = "根据会员价格属性分页查询会员价格信息列表")
	@RequestMapping(value = "/memberprices", method = RequestMethod.GET)
	public Object queryMemberPricePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, MemberPrice memberPrice) {				
		return memberPriceService.queryMemberPriceForPage(pagenum, pagesize, sort, memberPrice);
	}

}
