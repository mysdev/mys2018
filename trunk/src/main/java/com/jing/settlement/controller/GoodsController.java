package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.Goods;
import com.jing.settlement.service.GoodsService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsController
 * @Description: 商品服务HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="商品服务", tags={"SettlementGoods"})
public class GoodsController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private GoodsService goodsService;

	
	@ApiOperation(value = "新增 添加商品服务信息", notes = "添加商品服务信息")
	@RequestMapping(value = "/goods", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoods(HttpServletResponse response,
			@ApiParam(value = "goods") @RequestBody Goods goods) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goods, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goods.setGoodsId(null);
		goodsService.addGoods(goods);
		return goods;
	}
	
	
	@ApiOperation(value = "更新 根据商品服务标识更新商品服务信息", notes = "根据商品服务标识更新商品服务信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsById(HttpServletResponse response,
			@PathVariable String goodsId,
			@ApiParam(value = "goods", required = true) @RequestBody Goods goods
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goods, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Goods tempGoods = goodsService.queryGoodsByGoodsId(goodsId);
		goods.setGoodsId(goodsId);
		if(null == tempGoods){
			throw new NotFoundException("商品服务");
		}
		return goodsService.modifyGoods(goods);
	}

	@ApiOperation(value = "删除 根据商品服务标识删除商品服务信息", notes = "根据商品服务标识删除商品服务信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsByGoodsId(HttpServletResponse response, @PathVariable String goodsId) {
		Goods goods = goodsService.queryGoodsByGoodsId(goodsId);
		if(null == goods){
			throw new NotFoundException("商品服务");
		}
		return goodsService.dropGoodsByGoodsId(goodsId);
	}
	
	@ApiOperation(value = "查询 根据商品服务标识查询商品服务信息", notes = "根据商品服务标识查询商品服务信息")
	@RequestMapping(value = "/goods/{goodsId:.+}", method = RequestMethod.GET)
	public Object queryGoodsById(HttpServletResponse response,
			@PathVariable String goodsId) {
		Goods goods = goodsService.queryGoodsByGoodsId(goodsId);
		if(null == goods){
			throw new NotFoundException("商品服务");
		}
		return goods;
	}
	
	@ApiOperation(value = "查询 根据商品服务属性查询商品服务信息列表", notes = "根据商品服务属性查询商品服务信息列表")
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public Object queryGoodsList(HttpServletResponse response,
			Goods goods) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return goodsService.queryGoodsByProperty(ClassUtil.transBean2Map(goods, false));
	}
	
	@ApiOperation(value = "查询分页 根据商品服务属性分页查询商品服务信息列表", notes = "根据商品服务属性分页查询商品服务信息列表")
	@RequestMapping(value = "/goodss", method = RequestMethod.GET)
	public Object queryGoodsPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Goods goods) {				
		return goodsService.queryGoodsForPage(pagenum, pagesize, sort, goods);
	}

}
