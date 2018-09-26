package com.jing.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.attendance.service.AttendanceService;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: AttendanceDetailController
 * @Description: 门店考勤详情HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 09时32分
 */
@RestController
@Api(description="门店考勤规则详情", tags={"AttendanceDetail"})
public class AttendanceDetailController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceDetailService attendanceDetailService;
	@Autowired
	private AttendanceService attendanceService;
	

	@ApiOperation(value = "查询 带详情的考勤规则设定历史信息", notes = "返回有数据记录的月份")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/details/yearmonth", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryAttendanceDetail(HttpServletResponse response,
			@PathVariable Integer attendanceId) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		if(tempAttendance.getTypes()==null || tempAttendance.getTypes().intValue()!=2){
			throw new CustomException(400, "参数错误", "attendanceId", "此考勤规则不支持详情设置。");
		}		
		return attendanceDetailService.queryAttendanceDetailHistory(attendanceId);
	}
	
	@ApiOperation(value = "查询 初始带详情的考勤规则信息", notes = "未初始的月份初始化并返回带详情-已初始过的直接返回详情")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/details", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryAttendanceDetail(HttpServletResponse response,
			@PathVariable Integer attendanceId, String yearMonth, @SessionAttr(Config.USER_INFO) User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		if(tempAttendance.getTypes()==null || tempAttendance.getTypes().intValue()!=2){
			throw new CustomException(400, "参数错误", "attendanceId", "此考勤规则不支持详情设置。");
		}
		if(yearMonth!=null && yearMonth.length()>0){
			if(!DateUtil.is20yyMM(yearMonth)){
				throw new CustomException(400, "参数错误", "yearMonth", "年月格式不正确(20YY-MM)。");
			}
		}
		return attendanceDetailService.queryAttendanceDetail(attendanceId, yearMonth, user.getUserId());
	}
	
	@ApiOperation(value = "更新 根据门店考勤详情标识更新门店考勤详情信息", notes = "timeId为0时不考勤，其它为考勤")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/detail/{attId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailById(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@PathVariable Integer attId,
			@RequestParam(value = "timeId", required = true) Integer timeId, @SessionAttr(Config.USER_INFO) User user
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if(null==timeId || timeId.intValue()<0) {
			throw new CustomException(400, "参数错误", "timeId", "时段参数必传，休息时传0。");
		}
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		AttendanceDetail tempAttendanceDetail = attendanceDetailService.queryAttendanceDetailByAttId(attId);
		if(null == tempAttendanceDetail){
			throw new NotFoundException("门店考勤详情");
		}
		if(tempAttendanceDetail.getAttendanceId().intValue()!=attendanceId.intValue()){
			throw new CustomException(400, "参数错误", "attId", "详情与规则不匹配。");
		}
		if(tempAttendanceDetail.getEditable().intValue()!=0) {
			throw new CustomException(400, "参数错误", "attId", "规则已成历史，不允许修订。");
		}	
		
		AttendanceDetail attendanceDetail = new AttendanceDetail();		
		//仅要求以下三个参数
		attendanceDetail.setAttId(attId);
		attendanceDetail.setTimeId(timeId);
		attendanceDetail.setAttendance(timeId.intValue()==0?0:1);
		attendanceDetail.setAttDate(tempAttendanceDetail.getAttDate());
		//清空已经固定无无须修订的参数
		attendanceDetail.setAttendanceId(null);		
		attendanceDetail.setAttDay(null);
		attendanceDetail.setAttMonth(null);
		attendanceDetail.setWeekday(null);	
		attendanceDetail.setCreatedBy(null);
		attendanceDetail.setEditable(null);
		attendanceDetail.setUpdatedBy(user.getUserId());
		return attendanceDetailService.modifyAttendanceDetail(attendanceDetail);
	}
	
	
	@ApiOperation(value = "更新 批量根据门店考勤详情标识更新门店考勤详情信息", notes = "只接受同一规则里详情的批量修订")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/details", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailBatchById(HttpServletResponse response,
			@PathVariable Integer attendanceId, @RequestBody AttendanceDetail[] attendanceList, @SessionAttr(Config.USER_INFO) User user
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);		
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤规则");
		}
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
		
		//循环处理内部数据有效性
		for(int i=0; i<attendanceList.length; i++){
			if(attendanceList[i]==null || attendanceList[i].getAttId()==null || attendanceList[i].getTimeId()==null
					|| attendanceList[i].getTimeId().intValue()<0){
				Map<String, String> e0 = new HashMap<String, String>();
				e0.put("index", ""+i);
				e0.put("filed", "attId\\timeId");
				e0.put("message", "标识与考勤时段(0为休息)为必传参数。");
				errors.add(e0);
				continue;
			}		
			AttendanceDetail aaa = attendanceDetailService.queryAttendanceDetailByAttId(attendanceList[i].getAttId());
			if(aaa.getAttendanceId()!=attendanceId.intValue()){
				Map<String, String> e = new HashMap<String, String>();
				e.put("index", ""+i);
				e.put("filed", "attId");
				e.put("message", "详情不存在或归属规则不匹配。");
				errors.add(e);
				continue;
			}
			if(aaa.getEditable()!=0){
				Map<String, String> e = new HashMap<String, String>();
				e.put("index", ""+i);
				e.put("filed", "attId");
				e.put("message", "规则已成历史，不允许修订。");
				errors.add(e);
				continue;
			}
			attendanceList[i].setAttendanceId(attendanceId);
			attendanceList[i].setTimeId(attendanceList[i].getTimeId());
			attendanceList[i].setAttendance(attendanceList[i].getTimeId().intValue()==0?0:1);
			attendanceList[i].setAttDate(aaa.getAttDate());
			//清空已经固定无无须修订的参数
			attendanceList[i].setAttDate(null);
			attendanceList[i].setAttDay(null);
			attendanceList[i].setAttMonth(null);
			attendanceList[i].setWeekday(null);	
			attendanceList[i].setCreatedBy(null);
			attendanceList[i].setEditable(null);
			attendanceList[i].setUpdatedBy(user.getUserId());
		}
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		return attendanceDetailService.modifyAttendanceDetailBatch(attendanceList);
	}

}
