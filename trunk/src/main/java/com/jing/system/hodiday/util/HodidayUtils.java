package com.jing.system.hodiday.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.system.hodiday.entity.Hodiday;
import com.jing.system.hodiday.service.HodidayService;
import com.jing.utils.DateUtils;
import com.jing.utils.SpringContextHolder;

public class HodidayUtils {
	
	private static Map<String, Boolean> mapper = new HashMap<String, Boolean>();

	/**
	 * 判断今天是否是工作日
	 * @return
	 */
	public static boolean isWorkDay(){
		String day = DateUtils.getDateFormat(new Date(), "yyyyMMdd");
		Boolean isWorkDay = mapper.get(day);
		if(isWorkDay != null ){
			return isWorkDay;
		}
		//去查假日调整表
		HodidayService hodidayPubService = (HodidayService)SpringContextHolder.getBean("hodidayPubService");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hnumber", day);
		List<Hodiday> list = hodidayPubService.findHodidayList(map);
		
		if(list == null || list.size()<1){
			//没有特殊设置，通过常规判断
			boolean iswork = DateUtils.isWorkDay();
			mapper.put(day, iswork);
			return iswork;
		}else{
			//有特殊设置，以特殊设置为准
			Hodiday hodiday = list.get(0);
			if("1".equals(hodiday.getHtype())){
				//工作日
				mapper.put(day, true);
				return true;
			}else{
				mapper.put(day, false);
				return false;
			}
		}
	}
}
