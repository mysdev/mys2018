package com.jing.trade.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.trade.model.entity.Volume;

/**
 * @ClassName: VolumeMapper
 * @Description: 优惠券映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface VolumeMapper {

	/**
	 * @Title: addVolume
	 * @Description:添加优惠券
	 * @param volume 实体
	 * @return Integer
	 */
	Integer addVolume(Volume volume);
	
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
	 * @param pageBounds 分页信息
	 * @param volume 实体
	 * @return List<Volume>
	 */
	List<Volume> queryVolumeForPage(PageBounds pageBounds, @Param("volume") Volume volume);
	 
	 /**
	  * @Title: queryVolumeByProperty
	  * @Description:根据属性查询优惠券
	  * @return List<Volume>
	  */
	 List<Volume> queryVolumeByProperty(@Param("volume") Map<String, Object> map);
	 
	 
	 
}
