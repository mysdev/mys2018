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

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.attendance.service.AttendanceService;
import com.jing.attendance.service.bo.AttendanceBo;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: AttendanceController
 * @Description: 门店考勤HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="门店考勤")
public class AttendanceController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private AttendanceDetailService attendanceDetailService;

	
	
	@ApiOperation(value = "新增 添加门店考勤信息", notes = "添加门店考勤信息")
	@RequestMapping(value = "/attendance", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAttendance(HttpServletResponse response,
			@ApiParam(value = "attendance") @RequestBody Attendance attendance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendance, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		if(attendance.getTypes().intValue()<2 && (attendance.getAttendance()==null || attendance.getAttendance().intValue()==0)){
			throw new ParameterException("attendance","类型为0休天数或1考勤天数时，对应天数必传且不能为零。");
		}
		attendance.setAttendanceId(null);
		attendanceService.addAttendance(attendance);
		if(attendance.getTypes().intValue()==2){
			AttendanceBo bo = new AttendanceBo(attendance);
			bo.setAttendanceDetailList(attendanceDetailService.queryAttendanceDetail(attendance.getAttendanceId(), null));
			return bo; //带详情的考勤规则
		}
		return attendance;
	}
	
	
	@ApiOperation(value = "更新 根据门店考勤标识更新门店考勤信息", notes = "根据门店考勤标识更新门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceById(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@ApiParam(value = "attendance", required = true) @RequestBody Attendance attendance
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendance, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}		
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤");
		}
		if(attendance.getTypes()!=null && attendance.getTypes().intValue()!=tempAttendance.getTypes().intValue()){
			throw new ParameterException("types","门店考勤类型不允许变更。");
		}
		attendance.setAttendanceId(attendanceId);
		return attendanceService.modifyAttendance(attendance);
	}

	@ApiOperation(value = "删除 根据门店考勤标识删除门店考勤信息", notes = "根据门店考勤标识删除门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.DELETE)
	public Object dropAttendanceByAttendanceId(HttpServletResponse response, @PathVariable Integer attendanceId) {
		Attendance attendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		if(null == attendance){
			throw new NotFoundException("门店考勤");
		}
		return attendanceService.dropAttendanceByAttendanceId(attendanceId);
	}
	
	@ApiOperation(value = "查询 根据门店考勤标识查询门店考勤信息", notes = "根据门店考勤标识查询门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.GET)
	public Object queryAttendanceById(HttpServletResponse response,
			@PathVariable Integer attendanceId) {
		Attendance attendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		if(null == attendance){
			throw new NotFoundException("门店考勤");
		}
		if(attendance.getTypes().intValue()==2){
			AttendanceBo bo = new AttendanceBo(attendance);
			bo.setAttendanceDetailList(attendanceDetailService.queryAttendanceDetail(attendanceId, null));
			return bo; //带详情的考勤规则
		}
		return attendance;
	}
	
	@ApiOperation(value = "查询 根据门店考勤属性查询门店考勤信息列表", notes = "根据门店考勤属性查询门店考勤信息列表")
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public Object queryAttendanceList(HttpServletResponse response,
			Attendance attendance) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		if(attendance==null){
			attendance = new Attendance();			
		}
		if(attendance.getStatus()==null){
			attendance.setStatus(0);//默认只查询正在使用的规则
		}
		return attendanceService.queryAttendanceByProperty(ClassUtil.transBean2Map(attendance, false));
	}
	
	@ApiOperation(value = "查询分页 根据门店考勤属性分页查询门店考勤信息列表", notes = "根据门店考勤属性分页查询门店考勤信息列表")
	@RequestMapping(value = "/attendances", method = RequestMethod.GET)
	public Object queryAttendancePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Attendance attendance) {				
		return attendanceService.queryAttendanceForPage(pagenum, pagesize, sort, attendance);
	}
	
	@ApiOperation(value = "初始 初始带详情的考勤规则信息", notes = "初始带详情的考勤规则信息-已初始过的返回详情")
	@RequestMapping(value = "/attendancedetail/{attendanceId:.+}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object initAttendanceDetail(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@ApiParam(value = "yearMonth", required = false) String yearMonth) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		if(tempAttendance.getTypes()==null || tempAttendance.getTypes().intValue()!=2){
			throw new CustomException(400, "参数错误", "attendanceId", "此考勤规则不支持详情设置。");
		}
		return attendanceDetailService.createAttendanceDetail(attendanceId, yearMonth);
	}
	
	@ApiOperation(value = "查询 初始带详情的考勤规则信息", notes = "初始带详情的考勤规则信息-已初始过的返回详情")
	@RequestMapping(value = "/attendancedetail/{attendanceId:.+}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryAttendanceDetail(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@ApiParam(value = "yearMonth", required = false) String yearMonth) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		if(tempAttendance.getTypes()==null || tempAttendance.getTypes().intValue()!=2){
			throw new CustomException(400, "参数错误", "attendanceId", "此考勤规则不支持详情设置。");
		}
		return attendanceDetailService.queryAttendanceDetail(attendanceId, yearMonth);
	}
	
	@ApiOperation(value = "更新 根据门店考勤详情标识更新门店考勤详情信息", notes = "根据门店考勤详情标识更新门店考勤详情信息")
	@RequestMapping(value = "/attendancedetail/{attId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailById(HttpServletResponse response,
			@PathVariable Integer attId,
			@ApiParam(value = "attendance", required = true) Integer attendance
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		AttendanceDetail attendanceDetail = new AttendanceDetail();
		attendanceDetail.setAttendance(attendance);
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
	
//	@ApiOperation(value = "更新 根据门店考勤详情标识更新门店考勤详情信息", notes = "根据门店考勤详情标识更新门店考勤详情信息")
//	@RequestMapping(value = "/attendancedetails/{attendanceId:.+}", method = RequestMethod.PUT)
//	public Object modifyAttendanceDetailByAttendanceId(HttpServletResponse response,
//			@PathVariable Integer attendanceId,
//			@ApiParam(value = "attendanceBo", required = true) AttendanceBo attendanceBo
//			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {		
//		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendanceBo, false);
//		errors.addAll(beanValidator.validateClassAuto(attendanceBo.getAttendanceDetailList(), false));
//		if(!errors.isEmpty()){
//			throw new ParameterException(errors);
//		}
//		//循环处理内部数据有效性 暂不实现
//		return attendanceBo;
//	}

}
