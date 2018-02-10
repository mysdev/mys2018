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
import com.jing.core.model.entity.Store;
import com.jing.core.service.StoreService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: StoreController
 * @Description: 门店HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="门店", tags={"CoreStore"})
public class StoreController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private StoreService storeService;

	
	@ApiOperation(value = "新增 添加门店信息", notes = "添加门店信息")
	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addStore(HttpServletResponse response,
			@ApiParam(value = "store") @RequestBody Store store) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(store, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		store.setStoreId(null);
		storeService.addStore(store);
		return store;
	}
	
	
	@ApiOperation(value = "更新 根据门店标识更新门店信息", notes = "根据门店标识更新门店信息")
	@RequestMapping(value = "/store/{storeId:.+}", method = RequestMethod.PUT)
	public Object modifyStoreById(HttpServletResponse response,
			@PathVariable String storeId,
			@ApiParam(value = "store", required = true) @RequestBody Store store
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(store, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Store tempStore = storeService.queryStoreByStoreId(storeId);
		store.setStoreId(storeId);
		if(null == tempStore){
			throw new NotFoundException("门店");
		}
		return storeService.modifyStore(store);
	}

	@ApiOperation(value = "删除 根据门店标识删除门店信息", notes = "根据门店标识删除门店信息")
	@RequestMapping(value = "/store/{storeId:.+}", method = RequestMethod.DELETE)
	public Object dropStoreByStoreId(HttpServletResponse response, @PathVariable String storeId) {
		Store store = storeService.queryStoreByStoreId(storeId);
		if(null == store){
			throw new NotFoundException("门店");
		}
		return storeService.dropStoreByStoreId(storeId);
	}
	
	@ApiOperation(value = "查询 根据门店标识查询门店信息", notes = "根据门店标识查询门店信息")
	@RequestMapping(value = "/store/{storeId:.+}", method = RequestMethod.GET)
	public Object queryStoreById(HttpServletResponse response,
			@PathVariable String storeId) {
		Store store = storeService.queryStoreByStoreId(storeId);
		if(null == store){
			throw new NotFoundException("门店");
		}
		return store;
	}
	
	@ApiOperation(value = "查询 根据门店属性查询门店信息列表", notes = "根据门店属性查询门店信息列表")
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public Object queryStoreList(HttpServletResponse response,
			Store store) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return storeService.queryStoreByProperty(ClassUtil.transBean2Map(store, false));
	}
	
	@ApiOperation(value = "查询分页 根据门店属性分页查询门店信息列表", notes = "根据门店属性分页查询门店信息列表")
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public Object queryStorePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Store store) {				
		return storeService.queryStoreForPage(pagenum, pagesize, sort, store);
	}

}
