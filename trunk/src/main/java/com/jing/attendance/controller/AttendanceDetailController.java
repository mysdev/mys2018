package com.jing.attendance.controller;

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
import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: AttendanceDetailController
 * @Description: 门店考勤详情HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="门店考勤详情")
public class AttendanceDetailController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceDetailService attendanceDetailService;

	
	@ApiOperation(value = "新增 添加门店考勤详情信息", notes = "添加门店考勤详情信息")
	@RequestMapping(value = "/attendancedetail", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAttendanceDetail(HttpServletResponse response,
			@ApiParam(value = "attendanceDetail") @RequestBody AttendanceDetail attendanceDetail) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendanceDetail, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		attendanceDetail.setAttId(null);
		attendanceDetailService.addAttendanceDetail(attendanceDetail);
		return attendanceDetail;
	}
	
	
	@ApiOperation(value = "更新 根据门店考勤详情标识更新门店考勤详情信息", notes = "根据门店考勤详情标识更新门店考勤详情信息")
	@RequestMapping(value = "/attendancedetail/{attId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailById(HttpServletResponse response,
			@PathVariable Integer attId,
			@ApiParam(value = "attendanceDetail", required = true) @RequestBody AttendanceDetail attendanceDetail
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendanceDetail, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		AttendanceDetail tempAttendanceDetail = attendanceDetailService.queryAttendanceDetailByAttId(attId);
		attendanceDetail.setAttId(attId);
		if(null == tempAttendanceDetail){
			throw new NotFoundException("门店考勤详情");
		}
		return attendanceDetailService.modifyAttendanceDetail(attendanceDetail);
	}

	@ApiOperation(value = "删除 根据门店考勤详情标识删除门店考勤详情信息", notes = "根据门店考勤详情标识删除门店考勤详情信息")
	@RequestMapping(value = "/attendancedetail/{attId:.+}", method = RequestMethod.DELETE)
	public Object dropAttendanceDetailByAttId(HttpServletResponse response, @PathVariable Integer attId) {
		AttendanceDetail attendanceDetail = attendanceDetailService.queryAttendanceDetailByAttId(attId);
		if(null == attendanceDetail){
			throw new NotFoundException("门店考勤详情");
		}
		return attendanceDetailService.dropAttendanceDetailByAttId(attId);
	}
	
	@ApiOperation(value = "查询 根据门店考勤详情标识查询门店考勤详情信息", notes = "根据门店考勤详情标识查询门店考勤详情信息")
	@RequestMapping(value = "/attendancedetail/{attId:.+}", method = RequestMethod.GET)
	public Object queryAttendanceDetailById(HttpServletResponse response,
			@PathVariable Integer attId) {
		AttendanceDetail attendanceDetail = attendanceDetailService.queryAttendanceDetailByAttId(attId);
		if(null == attendanceDetail){
			throw new NotFoundException("门店考勤详情");
		}
		return attendanceDetail;
	}
	
	@ApiOperation(value = "查询 根据门店考勤详情属性查询门店考勤详情信息列表", notes = "根据门店考勤详情属性查询门店考勤详情信息列表")
	@RequestMapping(value = "/attendancedetail", method = RequestMethod.GET)
	public Object queryAttendanceDetailList(HttpServletResponse response,
			AttendanceDetail attendanceDetail) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return attendanceDetailService.queryAttendanceDetailByProperty(ClassUtil.transBean2Map(attendanceDetail, false));
	}
	
	@ApiOperation(value = "查询分页 根据门店考勤详情属性分页查询门店考勤详情信息列表", notes = "根据门店考勤详情属性分页查询门店考勤详情信息列表")
	@RequestMapping(value = "/attendancedetails", method = RequestMethod.GET)
	public Object queryAttendanceDetailPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, AttendanceDetail attendanceDetail) {				
		return attendanceDetailService.queryAttendanceDetailForPage(pagenum, pagesize, sort, attendanceDetail);
	}

}
