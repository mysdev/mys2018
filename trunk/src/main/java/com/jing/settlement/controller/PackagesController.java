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
import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.service.PackagesService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: PackagesController
 * @Description: 消费套餐HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="消费套餐", tags={"SettlementPackages"})
public class PackagesController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private PackagesService packagesService;

	
	@ApiOperation(value = "新增 添加消费套餐信息", notes = "添加消费套餐信息")
	@RequestMapping(value = "/packages", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addPackages(HttpServletResponse response,
			@ApiParam(value = "packages") @RequestBody Packages packages) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(packages, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		packages.setPackageId(null);
		packagesService.addPackages(packages);
		return packages;
	}
	
	
	@ApiOperation(value = "更新 根据消费套餐标识更新消费套餐信息", notes = "根据消费套餐标识更新消费套餐信息")
	@RequestMapping(value = "/packages/{packageId:.+}", method = RequestMethod.PUT)
	public Object modifyPackagesById(HttpServletResponse response,
			@PathVariable String packageId,
			@ApiParam(value = "packages", required = true) @RequestBody Packages packages
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(packages, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Packages tempPackages = packagesService.queryPackagesByPackageId(packageId);
		packages.setPackageId(packageId);
		if(null == tempPackages){
			throw new NotFoundException("消费套餐");
		}
		return packagesService.modifyPackages(packages);
	}

	@ApiOperation(value = "删除 根据消费套餐标识删除消费套餐信息", notes = "根据消费套餐标识删除消费套餐信息")
	@RequestMapping(value = "/packages/{packageId:.+}", method = RequestMethod.DELETE)
	public Object dropPackagesByPackageId(HttpServletResponse response, @PathVariable String packageId) {
		Packages packages = packagesService.queryPackagesByPackageId(packageId);
		if(null == packages){
			throw new NotFoundException("消费套餐");
		}
		return packagesService.dropPackagesByPackageId(packageId);
	}
	
	@ApiOperation(value = "查询 根据消费套餐标识查询消费套餐信息", notes = "根据消费套餐标识查询消费套餐信息")
	@RequestMapping(value = "/packages/{packageId:.+}", method = RequestMethod.GET)
	public Object queryPackagesById(HttpServletResponse response,
			@PathVariable String packageId) {
		Packages packages = packagesService.queryPackagesByPackageId(packageId);
		if(null == packages){
			throw new NotFoundException("消费套餐");
		}
		return packages;
	}
	
	@ApiOperation(value = "查询 根据消费套餐属性查询消费套餐信息列表", notes = "根据消费套餐属性查询消费套餐信息列表")
	@RequestMapping(value = "/packages", method = RequestMethod.GET)
	public Object queryPackagesList(HttpServletResponse response,
			Packages packages) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return packagesService.queryPackagesByProperty(ClassUtil.transBean2Map(packages, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费套餐属性分页查询消费套餐信息列表", notes = "根据消费套餐属性分页查询消费套餐信息列表")
	@RequestMapping(value = "/packagess", method = RequestMethod.GET)
	public Object queryPackagesPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Packages packages) {				
		return packagesService.queryPackagesForPage(pagenum, pagesize, sort, packages);
	}

}
