package com.jing.system.dictionary.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jing.config.web.exception.CustomException;
import com.jing.core.cache.CacheMap;
import com.jing.core.cache.CacheObservable;
import com.jing.core.cache.CacheObserver;
import com.jing.system.dictionary.entity.Dictionary;
import com.jing.system.dictionary.entity.DictionaryGroup;
import com.jing.system.dictionary.service.DictionaryService;
import com.jing.utils.SpringContextHolder;

public class DictionaryMapper implements CacheObserver {

	private static CacheMap<String, List<Dictionary>> objMapper = new CacheMap<String, List<Dictionary>>("dict&obj");

	static {
		load();
		CacheObservable.addObserver(new DictionaryMapper());
	}
	
	@Override
	public void init() {
		DictionaryMapper.load();
	}
	
	public static void load() {
		DictionaryService dictionaryService = (DictionaryService) SpringContextHolder.getBean("dictionaryService");
		List<DictionaryGroup> list = dictionaryService.findAllDictionaryGroup();
		if (list != null && list.size()>0) {
			for (DictionaryGroup dictionaryGroup : list) {
				objMapper.put(dictionaryGroup.getCode(), dictionaryGroup.getDictionarys(),600000);
			}
		}
	}

	public static String getValue(String groupCode, String code) {
		if(code==null || "".equals(code)){
			return "";
		}
		if (objMapper.get(groupCode) != null) {
			List<Dictionary> list = objMapper.get(groupCode);
			for (Dictionary dictionary : list) {
				if (code.equals(dictionary.getCode())) {
					return dictionary.getValue();
				}
			}
		}
		return "数据错误";
	}

	public synchronized static void setValue(Dictionary dict) {
		List<Dictionary> list = objMapper.get(dict.getGroupCode());
		if (list == null) {
			list = new ArrayList<Dictionary>();
			list.add(dict);
			objMapper.put(dict.getGroupCode(), list,600000);
		} else {
			list.add(dict);
		}
	}

	public static List<Dictionary> getAll(String groupCode) {
		return objMapper.get(groupCode);
	}
	
	public static String getJsonString(){
		List<Map<String, Object>> gl = new ArrayList<Map<String, Object>>();
		Set<String> set = objMapper.keySet();
		for(String groupCode : set){
			Map<String, Object> g = new HashMap<String, Object>();
			g.put("code", groupCode);
			List<Map<String, String>> dl = new ArrayList<Map<String, String>>();
			for (Dictionary dictionary : objMapper.get(groupCode)) {
				Map<String, String> d = new HashMap<String, String>();
				d.put("code", dictionary.getCode());
				d.put("value", dictionary.getValue());
				d.put("flag", dictionary.getFlag()+"");
				dl.add(d);
			}
			g.put("dictionarys", dl);
			gl.add(g);
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(gl);
		} catch (JsonProcessingException e) {
			throw new CustomException("数据字典json字符串生成异常.");
		}
	}
	
	public static List<Map<String, Object>> getJsonObj(){
		List<Map<String, Object>> gl = new ArrayList<Map<String, Object>>();
		Set<String> set = objMapper.keySet();
		for(String groupCode : set){
			Map<String, Object> g = new HashMap<String, Object>();
			g.put("code", groupCode);
			List<Map<String, String>> dl = new ArrayList<Map<String, String>>();
			for (Dictionary dictionary : objMapper.get(groupCode)) {
				Map<String, String> d = new HashMap<String, String>();
				d.put("code", dictionary.getCode());
				d.put("value", dictionary.getValue());
				d.put("flag", dictionary.getFlag()+"");
				dl.add(d);
			}
			g.put("dictionarys", dl);
			gl.add(g);
		}
		return gl;
	}
	
	public static String getCode(String groupCode,String value){
		if(value==null){
			return null;
		}
		List<Dictionary> list = objMapper.get(groupCode);
		for (Dictionary dictionary : list) {
			if(value.equals(dictionary.getValue())){
				return dictionary.getCode();
			}
		}
		return null;
	}

	public static Dictionary getObj(String groupCode, String code) {
		if(code==null || "".equals(code)){
			return null;
		}
		if (objMapper.get(groupCode) != null) {
			List<Dictionary> list = objMapper.get(groupCode);
			for (Dictionary dictionary : list) {
				if (code.equals(dictionary.getCode())) {
					return dictionary;
				}
			}
		}
		return null;
	}

}
