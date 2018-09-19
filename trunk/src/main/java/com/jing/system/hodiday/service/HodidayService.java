package com.jing.system.hodiday.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.hodiday.entity.Hodiday;

public interface HodidayService {

	/**
	* 添加 节假日
	*/
	void addHodiday(Hodiday hodiday);
	
	/**
	* 修改 节假日
	*/
	void updateHodiday(Hodiday hodiday);
	
	/**
	*根据ID删除记录
	*/
	void deleteHodidayById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Hodiday getHodidayById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findHodidayListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询节假日
	 * @param param
	 * @return
	 */
	List<Hodiday> findHodidayList(Map<String, Object> param);
}