package com.jing.system.hodiday.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.hodiday.dao.HodidayDao;
import com.jing.system.hodiday.entity.Hodiday;
import com.jing.system.hodiday.service.HodidayService;
import com.jing.utils.PrimaryKey;

@Service("hodidayService")
public class HodidayServiceImpl implements HodidayService{

	@Resource
	private HodidayDao hodidayDao;

	/**
	* 添加 节假日
	*/
	@Override
	public void addHodiday(Hodiday hodiday){
		hodiday.setHid(PrimaryKey.getUUID());
		hodidayDao.addHodiday(hodiday);
	}
	
	/**
	* 修改 节假日
	*/
	@Override
	public void updateHodiday(Hodiday hodiday){
		hodidayDao.updateHodiday(hodiday);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteHodidayById(String id){
		hodidayDao.deleteHodidayById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Hodiday getHodidayById(String id){
		return hodidayDao.getHodidayById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findHodidayListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(hodidayDao.findHodidayListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询节假日
	 * @param param
	 * @return
	 */
	 @Override
	public List<Hodiday> findHodidayList(Map<String, Object> param){
		return hodidayDao.findHodidayList(param);
	}
	
}