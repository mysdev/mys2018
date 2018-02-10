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
import com.jing.core.model.entity.Reservation;
import com.jing.core.service.ReservationService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ReservationController
 * @Description: 房间预定HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="房间预定", tags={"CoreReservation"})
public class ReservationController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ReservationService reservationService;

	
	@ApiOperation(value = "新增 添加房间预定信息", notes = "添加房间预定信息")
	@RequestMapping(value = "/reservation", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addReservation(HttpServletResponse response,
			@ApiParam(value = "reservation") @RequestBody Reservation reservation) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(reservation, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		reservation.setReservationId(null);
		reservationService.addReservation(reservation);
		return reservation;
	}
	
	
	@ApiOperation(value = "更新 根据房间预定标识更新房间预定信息", notes = "根据房间预定标识更新房间预定信息")
	@RequestMapping(value = "/reservation/{reservationId:.+}", method = RequestMethod.PUT)
	public Object modifyReservationById(HttpServletResponse response,
			@PathVariable Integer reservationId,
			@ApiParam(value = "reservation", required = true) @RequestBody Reservation reservation
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(reservation, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Reservation tempReservation = reservationService.queryReservationByReservationId(reservationId);
		reservation.setReservationId(reservationId);
		if(null == tempReservation){
			throw new NotFoundException("房间预定");
		}
		return reservationService.modifyReservation(reservation);
	}

	@ApiOperation(value = "删除 根据房间预定标识删除房间预定信息", notes = "根据房间预定标识删除房间预定信息")
	@RequestMapping(value = "/reservation/{reservationId:.+}", method = RequestMethod.DELETE)
	public Object dropReservationByReservationId(HttpServletResponse response, @PathVariable Integer reservationId) {
		Reservation reservation = reservationService.queryReservationByReservationId(reservationId);
		if(null == reservation){
			throw new NotFoundException("房间预定");
		}
		return reservationService.dropReservationByReservationId(reservationId);
	}
	
	@ApiOperation(value = "查询 根据房间预定标识查询房间预定信息", notes = "根据房间预定标识查询房间预定信息")
	@RequestMapping(value = "/reservation/{reservationId:.+}", method = RequestMethod.GET)
	public Object queryReservationById(HttpServletResponse response,
			@PathVariable Integer reservationId) {
		Reservation reservation = reservationService.queryReservationByReservationId(reservationId);
		if(null == reservation){
			throw new NotFoundException("房间预定");
		}
		return reservation;
	}
	
	@ApiOperation(value = "查询 根据房间预定属性查询房间预定信息列表", notes = "根据房间预定属性查询房间预定信息列表")
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public Object queryReservationList(HttpServletResponse response,
			Reservation reservation) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return reservationService.queryReservationByProperty(ClassUtil.transBean2Map(reservation, false));
	}
	
	@ApiOperation(value = "查询分页 根据房间预定属性分页查询房间预定信息列表", notes = "根据房间预定属性分页查询房间预定信息列表")
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public Object queryReservationPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Reservation reservation) {				
		return reservationService.queryReservationForPage(pagenum, pagesize, sort, reservation);
	}

}
