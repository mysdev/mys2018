package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.Volume;

/**
 * @ClassName: Volume
 * @Description: 优惠券服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface VolumeService {

    /**
	 * @Title: addVolume
	 * @Description:添加优惠券
	 * @param volume 实体
	 * @return Integer
	 */
	Volume addVolume(Volume volume);
	
	/**
	 * @Title modifyVolume
	 * @Description:修改优惠券
	 * @param volume 实体
	 * @return Integer
	 */
	Integer modifyVolume(Volume volume);
	
	/**
	 * @Title: dropVolumeByVolumeId
	 * @Description:删除优惠券
	 * @param volumeId 实体标识
	 * @return Integer
	 */
	Integer dropVolumeByVolumeId(Integer volumeId);
	
	/**
	 * @Title: queryVolumeByVolumeId
	 * @Description:根据实体标识查询优惠券
	 * @param volumeId 实体标识
	 * @return Volume
	 */
	Volume queryVolumeByVolumeId(Integer volumeId);
	 
	/**
	 * @Title: queryVolumeForPage
	 * @Description: 根据优惠券属性与分页信息分页查询优惠券信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param volume 实体
	 * @return List<Volume>
	 */
	Map<String, Object> queryVolumeForPage(Integer pagenum, Integer pagesize, String sort, Volume volume);
	 
	 /**
	 * @Title: queryVolumeByProperty
	 * @Description:根据属性查询优惠券
	 * @return List<Volume>
	 */
	 List<Volume> queryVolumeByProperty(Map<String, Object> map);	 
	 
}
