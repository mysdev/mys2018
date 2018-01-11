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
import com.jing.settlement.model.entity.GoodsUnit;
import com.jing.settlement.service.GoodsUnitService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsUnitController
 * @Description: 商品单位HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="商品单位")
public class GoodsUnitController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private GoodsUnitService goodsUnitService;

	
	@ApiOperation(value = "新增 添加商品单位信息", notes = "添加商品单位信息")
	@RequestMapping(value = "/goodsunit", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoodsUnit(HttpServletResponse response,
			@ApiParam(value = "goodsUnit") @RequestBody GoodsUnit goodsUnit) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsUnit, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goodsUnit.setUnitId(null);
		goodsUnitService.addGoodsUnit(goodsUnit);
		return goodsUnit;
	}
	
	
	@ApiOperation(value = "更新 根据商品单位标识更新商品单位信息", notes = "根据商品单位标识更新商品单位信息")
	@RequestMapping(value = "/goodsunit/{unitId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsUnitById(HttpServletResponse response,
			@PathVariable Integer unitId,
			@ApiParam(value = "goodsUnit", required = true) @RequestBody GoodsUnit goodsUnit
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsUnit, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		GoodsUnit tempGoodsUnit = goodsUnitService.queryGoodsUnitByUnitId(unitId);
		goodsUnit.setUnitId(unitId);
		if(null == tempGoodsUnit){
			throw new NotFoundException("商品单位");
		}
		return goodsUnitService.modifyGoodsUnit(goodsUnit);
	}

	@ApiOperation(value = "删除 根据商品单位标识删除商品单位信息", notes = "根据商品单位标识删除商品单位信息")
	@RequestMapping(value = "/goodsunit/{unitId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsUnitByUnitId(HttpServletResponse response, @PathVariable Integer unitId) {
		GoodsUnit goodsUnit = goodsUnitService.queryGoodsUnitByUnitId(unitId);
		if(null == goodsUnit){
			throw new NotFoundException("商品单位");
		}
		return goodsUnitService.dropGoodsUnitByUnitId(unitId);
	}
	
	@ApiOperation(value = "查询 根据商品单位标识查询商品单位信息", notes = "根据商品单位标识查询商品单位信息")
	@RequestMapping(value = "/goodsunit/{unitId:.+}", method = RequestMethod.GET)
	public Object queryGoodsUnitById(HttpServletResponse response,
			@PathVariable Integer unitId) {
		GoodsUnit goodsUnit = goodsUnitService.queryGoodsUnitByUnitId(unitId);
		if(null == goodsUnit){
			throw new NotFoundException("商品单位");
		}
		return goodsUnit;
	}
	
	@ApiOperation(value = "查询 根据商品单位属性查询商品单位信息列表", notes = "根据商品单位属性查询商品单位信息列表")
	@RequestMapping(value = "/goodsunit", method = RequestMethod.GET)
	public Object queryGoodsUnitList(HttpServletResponse response,
			GoodsUnit goodsUnit) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return goodsUnitService.queryGoodsUnitByProperty(ClassUtil.transBean2Map(goodsUnit, false));
	}
	
	@ApiOperation(value = "查询分页 根据商品单位属性分页查询商品单位信息列表", notes = "根据商品单位属性分页查询商品单位信息列表")
	@RequestMapping(value = "/goodsunits", method = RequestMethod.GET)
	public Object queryGoodsUnitPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, GoodsUnit goodsUnit) {				
		return goodsUnitService.queryGoodsUnitForPage(pagenum, pagesize, sort, goodsUnit);
	}

}
