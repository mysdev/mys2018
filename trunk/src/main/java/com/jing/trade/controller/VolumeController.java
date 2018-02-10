package com.jing.trade.controller;

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
import com.jing.trade.model.entity.Volume;
import com.jing.trade.service.VolumeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: VolumeController
 * @Description: 优惠券HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="优惠券", tags={"TradeVolume"})
public class VolumeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private VolumeService volumeService;

	
	@ApiOperation(value = "新增 添加优惠券信息", notes = "添加优惠券信息")
	@RequestMapping(value = "/volume", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addVolume(HttpServletResponse response,
			@ApiParam(value = "volume") @RequestBody Volume volume) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(volume, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		volume.setVolumeId(null);
		volumeService.addVolume(volume);
		return volume;
	}
	
	
	@ApiOperation(value = "更新 根据优惠券标识更新优惠券信息", notes = "根据优惠券标识更新优惠券信息")
	@RequestMapping(value = "/volume/{volumeId:.+}", method = RequestMethod.PUT)
	public Object modifyVolumeById(HttpServletResponse response,
			@PathVariable Integer volumeId,
			@ApiParam(value = "volume", required = true) @RequestBody Volume volume
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(volume, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Volume tempVolume = volumeService.queryVolumeByVolumeId(volumeId);
		volume.setVolumeId(volumeId);
		if(null == tempVolume){
			throw new NotFoundException("优惠券");
		}
		return volumeService.modifyVolume(volume);
	}

	@ApiOperation(value = "删除 根据优惠券标识删除优惠券信息", notes = "根据优惠券标识删除优惠券信息")
	@RequestMapping(value = "/volume/{volumeId:.+}", method = RequestMethod.DELETE)
	public Object dropVolumeByVolumeId(HttpServletResponse response, @PathVariable Integer volumeId) {
		Volume volume = volumeService.queryVolumeByVolumeId(volumeId);
		if(null == volume){
			throw new NotFoundException("优惠券");
		}
		return volumeService.dropVolumeByVolumeId(volumeId);
	}
	
	@ApiOperation(value = "查询 根据优惠券标识查询优惠券信息", notes = "根据优惠券标识查询优惠券信息")
	@RequestMapping(value = "/volume/{volumeId:.+}", method = RequestMethod.GET)
	public Object queryVolumeById(HttpServletResponse response,
			@PathVariable Integer volumeId) {
		Volume volume = volumeService.queryVolumeByVolumeId(volumeId);
		if(null == volume){
			throw new NotFoundException("优惠券");
		}
		return volume;
	}
	
	@ApiOperation(value = "查询 根据优惠券属性查询优惠券信息列表", notes = "根据优惠券属性查询优惠券信息列表")
	@RequestMapping(value = "/volume", method = RequestMethod.GET)
	public Object queryVolumeList(HttpServletResponse response,
			Volume volume) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return volumeService.queryVolumeByProperty(ClassUtil.transBean2Map(volume, false));
	}
	
	@ApiOperation(value = "查询分页 根据优惠券属性分页查询优惠券信息列表", notes = "根据优惠券属性分页查询优惠券信息列表")
	@RequestMapping(value = "/volumes", method = RequestMethod.GET)
	public Object queryVolumePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Volume volume) {				
		return volumeService.queryVolumeForPage(pagenum, pagesize, sort, volume);
	}

}
