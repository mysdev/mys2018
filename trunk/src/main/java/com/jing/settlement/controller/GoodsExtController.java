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
import com.jing.settlement.model.entity.GoodsExt;
import com.jing.settlement.service.GoodsExtService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsExtController
 * @Description: 商品服务扩展HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="商品服务扩展")
public class GoodsExtController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private GoodsExtService goodsExtService;

	
	@ApiOperation(value = "新增 添加商品服务扩展信息", notes = "添加商品服务扩展信息")
	@RequestMapping(value = "/goodsext", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoodsExt(HttpServletResponse response,
			@ApiParam(value = "goodsExt") @RequestBody GoodsExt goodsExt) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsExt, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goodsExt.setGoodsId(null);
		goodsExtService.addGoodsExt(goodsExt);
		return goodsExt;
	}
	
	
	@ApiOperation(value = "更新 根据商品服务扩展标识更新商品服务扩展信息", notes = "根据商品服务扩展标识更新商品服务扩展信息")
	@RequestMapping(value = "/goodsext/{goodsId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsExtById(HttpServletResponse response,
			@PathVariable String goodsId,
			@ApiParam(value = "goodsExt", required = true) @RequestBody GoodsExt goodsExt
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsExt, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		GoodsExt tempGoodsExt = goodsExtService.queryGoodsExtByGoodsId(goodsId);
		goodsExt.setGoodsId(goodsId);
		if(null == tempGoodsExt){
			throw new NotFoundException("商品服务扩展");
		}
		return goodsExtService.modifyGoodsExt(goodsExt);
	}

	@ApiOperation(value = "删除 根据商品服务扩展标识删除商品服务扩展信息", notes = "根据商品服务扩展标识删除商品服务扩展信息")
	@RequestMapping(value = "/goodsext/{goodsId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsExtByGoodsId(HttpServletResponse response, @PathVariable String goodsId) {
		GoodsExt goodsExt = goodsExtService.queryGoodsExtByGoodsId(goodsId);
		if(null == goodsExt){
			throw new NotFoundException("商品服务扩展");
		}
		return goodsExtService.dropGoodsExtByGoodsId(goodsId);
	}
	
	@ApiOperation(value = "查询 根据商品服务扩展标识查询商品服务扩展信息", notes = "根据商品服务扩展标识查询商品服务扩展信息")
	@RequestMapping(value = "/goodsext/{goodsId:.+}", method = RequestMethod.GET)
	public Object queryGoodsExtById(HttpServletResponse response,
			@PathVariable String goodsId) {
		GoodsExt goodsExt = goodsExtService.queryGoodsExtByGoodsId(goodsId);
		if(null == goodsExt){
			throw new NotFoundException("商品服务扩展");
		}
		return goodsExt;
	}
	
	@ApiOperation(value = "查询 根据商品服务扩展属性查询商品服务扩展信息列表", notes = "根据商品服务扩展属性查询商品服务扩展信息列表")
	@RequestMapping(value = "/goodsext", method = RequestMethod.GET)
	public Object queryGoodsExtList(HttpServletResponse response,
			GoodsExt goodsExt) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return goodsExtService.queryGoodsExtByProperty(ClassUtil.transBean2Map(goodsExt, false));
	}
	
	@ApiOperation(value = "查询分页 根据商品服务扩展属性分页查询商品服务扩展信息列表", notes = "根据商品服务扩展属性分页查询商品服务扩展信息列表")
	@RequestMapping(value = "/goodsexts", method = RequestMethod.GET)
	public Object queryGoodsExtPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, GoodsExt goodsExt) {				
		return goodsExtService.queryGoodsExtForPage(pagenum, pagesize, sort, goodsExt);
	}

}
