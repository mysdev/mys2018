package com.jing.trade.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.trade.model.dao.VolumeMapper;
import com.jing.trade.model.entity.Volume;
import com.jing.trade.service.VolumeService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Volume
 * @Description: 优惠券服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("volumeService")
@Transactional(readOnly=true)
public class  VolumeServiceImpl implements VolumeService {	
//	private static final Logger logger = LoggerFactory.getLogger(VolumeServiceImpl.class);
	
	@Autowired
    private VolumeMapper volumeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addVolume
	 * @Description:添加优惠券
	 * @param volume 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Volume addVolume(Volume volume){
		int ret = volumeMapper.addVolume(volume);
		if(ret>0){
			return volume;
		}
		return null;
	}
	
	/**
	 * @Title modifyVolume
	 * @Description:修改优惠券
	 * @param volume 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyVolume(Volume volume){
		return volumeMapper.modifyVolume(volume);
	}
	
	/**
	 * @Title: dropVolumeByVolumeId
	 * @Description:删除优惠券
	 * @param volumeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropVolumeByVolumeId(Integer volumeId){
		return volumeMapper.dropVolumeByVolumeId(volumeId);
	}
	
	/**
	 * @Title: queryVolumeByVolumeId
	 * @Description:根据实体标识查询优惠券
	 * @param volumeId 实体标识
	 * @return Volume
	 */
	@Override
	public Volume queryVolumeByVolumeId(Integer volumeId){
		return volumeMapper.queryVolumeByVolumeId(volumeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryVolumeForPage
	 * @Description: 根据优惠券属性与分页信息分页查询优惠券信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param volume 实体
	 * @return List<Volume>
	 */
	@Override
	public Map<String, Object> queryVolumeForPage(Integer pagenum, Integer pagesize, String sort, Volume volume){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Volume.class);
		List<Volume> entityList = volumeMapper.queryVolumeForPage(pageBounds, volume);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Volume.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Volume> pagelist = (PageList<Volume>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryVolumeByProperty
	 * @Description:根据属性查询优惠券
	 * @return List<Volume>
	 */
	@Override
	public List<Volume> queryVolumeByProperty(Map<String, Object> map){
		return volumeMapper.queryVolumeByProperty(map);
	}


}
