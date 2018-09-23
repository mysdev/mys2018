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
			@PathVariable Integer attendanceId, String yearMonth) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
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
		return attendanceDetailService.queryAttendanceDetail(attendanceId, yearMonth);
	}
	
	@ApiOperation(value = "更新 根据门店考勤详情标识更新门店考勤详情信息", notes = "根据门店考勤详情标识更新门店考勤详情信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/detail/{attId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailById(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@PathVariable Integer attId,
			@RequestParam(value = "attendance", required = true) Integer attendance
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
		if(tempAttendanceDetail.getAttendanceId().intValue()!=attendanceId.intValue()){
			throw new CustomException(400, "参数错误", "attId", "详情与规则不匹配。");
		}
		attendanceDetail.setEditable(null);
		return attendanceDetailService.modifyAttendanceDetail(attendanceDetail);
	}
	
	
	@ApiOperation(value = "更新 批量根据门店考勤详情标识更新门店考勤详情信息", notes = "批量根据门店考勤详情标识更新门店考勤详情信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/details", method = RequestMethod.PUT)
	public Object modifyAttendanceDetailBatchById(HttpServletResponse response,
			@PathVariable Integer attendanceId, @RequestBody AttendanceDetail[] attendanceList
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
		
		//循环处理内部数据有效性
		for(int i=0; i<attendanceList.length; i++){
			if(attendanceList[i]==null || attendanceList[i].getAttId()==null || attendanceList[i].getAttendance()==null
					|| (attendanceList[i].getAttendance().intValue()!=0 && attendanceList[i].getAttendance().intValue()!=1)){
				Map<String, String> e0 = new HashMap<String, String>();
				e0.put("index", ""+i);
				e0.put("filed", "attId\\attendance");
				e0.put("message", "标识与是否考勤(0或1)为必传参数。");
				continue;
			}			
			AttendanceDetail ad = attendanceDetailService.queryAttendanceDetailByAttId(attendanceList[0].getAttId());
			if(ad==null || ad.getAttendanceId().intValue()!=attendanceId.intValue()){
				Map<String, String> e = new HashMap<String, String>();
				e.put("index", ""+i);
				e.put("filed", "attId");
				e.put("message", "详情不存在或归属规则不匹配。");
				continue;
			}
			//清空无关参数
			attendanceList[i].setAttDate(null);
			attendanceList[i].setAttDay(null);
			attendanceList[i].setAttMonth(null);
			attendanceList[i].setWeekday(null);	
			attendanceList[i].setCreatedBy(null);
			attendanceList[i].setEditable(null);
		}
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		return attendanceDetailService.modifyAttendanceDetailBatch(attendanceList);
	}

}
