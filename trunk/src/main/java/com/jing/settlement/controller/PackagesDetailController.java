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
import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.service.PackagesDetailService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: PackagesDetailController
 * @Description: 消费套餐详情HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="消费套餐详情")
public class PackagesDetailController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private PackagesDetailService packagesDetailService;

	
	@ApiOperation(value = "新增 添加消费套餐详情信息", notes = "添加消费套餐详情信息")
	@RequestMapping(value = "/packagesdetail", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addPackagesDetail(HttpServletResponse response,
			@ApiParam(value = "packagesDetail") @RequestBody PackagesDetail packagesDetail) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(packagesDetail, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		packagesDetail.setDetailId(null);
		packagesDetailService.addPackagesDetail(packagesDetail);
		return packagesDetail;
	}
	
	
	@ApiOperation(value = "更新 根据消费套餐详情标识更新消费套餐详情信息", notes = "根据消费套餐详情标识更新消费套餐详情信息")
	@RequestMapping(value = "/packagesdetail/{detailId:.+}", method = RequestMethod.PUT)
	public Object modifyPackagesDetailById(HttpServletResponse response,
			@PathVariable Integer detailId,
			@ApiParam(value = "packagesDetail", required = true) @RequestBody PackagesDetail packagesDetail
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(packagesDetail, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		PackagesDetail tempPackagesDetail = packagesDetailService.queryPackagesDetailByDetailId(detailId);
		packagesDetail.setDetailId(detailId);
		if(null == tempPackagesDetail){
			throw new NotFoundException("消费套餐详情");
		}
		return packagesDetailService.modifyPackagesDetail(packagesDetail);
	}

	@ApiOperation(value = "删除 根据消费套餐详情标识删除消费套餐详情信息", notes = "根据消费套餐详情标识删除消费套餐详情信息")
	@RequestMapping(value = "/packagesdetail/{detailId:.+}", method = RequestMethod.DELETE)
	public Object dropPackagesDetailByDetailId(HttpServletResponse response, @PathVariable Integer detailId) {
		PackagesDetail packagesDetail = packagesDetailService.queryPackagesDetailByDetailId(detailId);
		if(null == packagesDetail){
			throw new NotFoundException("消费套餐详情");
		}
		return packagesDetailService.dropPackagesDetailByDetailId(detailId);
	}
	
	@ApiOperation(value = "查询 根据消费套餐详情标识查询消费套餐详情信息", notes = "根据消费套餐详情标识查询消费套餐详情信息")
	@RequestMapping(value = "/packagesdetail/{detailId:.+}", method = RequestMethod.GET)
	public Object queryPackagesDetailById(HttpServletResponse response,
			@PathVariable Integer detailId) {
		PackagesDetail packagesDetail = packagesDetailService.queryPackagesDetailByDetailId(detailId);
		if(null == packagesDetail){
			throw new NotFoundException("消费套餐详情");
		}
		return packagesDetail;
	}
	
	@ApiOperation(value = "查询 根据消费套餐详情属性查询消费套餐详情信息列表", notes = "根据消费套餐详情属性查询消费套餐详情信息列表")
	@RequestMapping(value = "/packagesdetail", method = RequestMethod.GET)
	public Object queryPackagesDetailList(HttpServletResponse response,
			PackagesDetail packagesDetail) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return packagesDetailService.queryPackagesDetailByProperty(ClassUtil.transBean2Map(packagesDetail, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费套餐详情属性分页查询消费套餐详情信息列表", notes = "根据消费套餐详情属性分页查询消费套餐详情信息列表")
	@RequestMapping(value = "/packagesdetails", method = RequestMethod.GET)
	public Object queryPackagesDetailPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, PackagesDetail packagesDetail) {				
		return packagesDetailService.queryPackagesDetailForPage(pagenum, pagesize, sort, packagesDetail);
	}

}
