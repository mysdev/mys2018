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
import com.jing.core.model.entity.Department;
import com.jing.core.service.DepartmentService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: DepartmentController
 * @Description: 部门HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="部门", tags={"CoreDepartment"})
public class DepartmentController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private DepartmentService departmentService;

	
	@ApiOperation(value = "新增 添加部门信息", notes = "添加部门信息")
	@RequestMapping(value = "/department", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addDepartment(HttpServletResponse response,
			@ApiParam(value = "department") @RequestBody Department department) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(department, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		department.setDptId(null);
		departmentService.addDepartment(department);
		return department;
	}
	
	
	@ApiOperation(value = "更新 根据部门标识更新部门信息", notes = "根据部门标识更新部门信息")
	@RequestMapping(value = "/department/{dptId:.+}", method = RequestMethod.PUT)
	public Object modifyDepartmentById(HttpServletResponse response,
			@PathVariable Integer dptId,
			@ApiParam(value = "department", required = true) @RequestBody Department department
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(department, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Department tempDepartment = departmentService.queryDepartmentByDptId(dptId);
		department.setDptId(dptId);
		if(null == tempDepartment){
			throw new NotFoundException("部门");
		}
		return departmentService.modifyDepartment(department);
	}

	@ApiOperation(value = "删除 根据部门标识删除部门信息", notes = "根据部门标识删除部门信息")
	@RequestMapping(value = "/department/{dptId:.+}", method = RequestMethod.DELETE)
	public Object dropDepartmentByDptId(HttpServletResponse response, @PathVariable Integer dptId) {
		Department department = departmentService.queryDepartmentByDptId(dptId);
		if(null == department){
			throw new NotFoundException("部门");
		}
		return departmentService.dropDepartmentByDptId(dptId);
	}
	
	@ApiOperation(value = "查询 根据部门标识查询部门信息", notes = "根据部门标识查询部门信息")
	@RequestMapping(value = "/department/{dptId:.+}", method = RequestMethod.GET)
	public Object queryDepartmentById(HttpServletResponse response,
			@PathVariable Integer dptId) {
		Department department = departmentService.queryDepartmentByDptId(dptId);
		if(null == department){
			throw new NotFoundException("部门");
		}
		return department;
	}
	
	@ApiOperation(value = "查询 根据部门属性查询部门信息列表", notes = "根据部门属性查询部门信息列表")
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public Object queryDepartmentList(HttpServletResponse response,
			Department department) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return departmentService.queryDepartmentByProperty(ClassUtil.transBean2Map(department, false));
	}
	
	@ApiOperation(value = "查询分页 根据部门属性分页查询部门信息列表", notes = "根据部门属性分页查询部门信息列表")
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public Object queryDepartmentPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Department department) {				
		return departmentService.queryDepartmentForPage(pagenum, pagesize, sort, department);
	}

}
