package com.jing.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**    
* @ClassName: PojoFieldUtil
* @Description: 对象class的处理工具类（需要逐步完善）
* @author lichao
* @date 2015-09-07  
* @version V1.0    
*/
public class JsonUtil {

	
	/**
	 * 
	* @Title: json2list  
	* @Description: json转list
	* @return List<Object>    返回类型  
	* @author li chao
	 * @param <T>
	* @throws  
	 */
	public static <T> List<T> json2List(String json,Class<T> clazz){ 
	    List<T> list = JSON.parseArray(json, clazz);
	    return list;
	  } 
	
	/**
	 * 
	* @Title: list2json  
	* @Description:list转json
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	@SuppressWarnings("rawtypes")
	public static String list2json(List list,SerializeFilter[] filters,SerializerFeature... features){ 
		 String json= JSON.toJSONString(list,filters,features); 
	    return json;
	  }
	
	
	@SuppressWarnings("rawtypes")
	public static String list2json(List list){ 
		 String json= JSON.toJSONString(list); 
	    return json;
	  } 
	
	
	/**
	 * 
	* @Title: set2json  
	* @Description:set转json
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	@SuppressWarnings("rawtypes")
	public static String set2json(Set set,SerializeFilter[] filters,SerializerFeature... features){ 
		 String json= JSON.toJSONString(set,filters,features); 
	    return json;
	  } 
	
	@SuppressWarnings("rawtypes")
	public static String set2json(Set set){ 
		 String json= JSON.toJSONString(set); 
	    return json;
	  } 
	
	/**
	 * 
	* @Title: json2map  
	* @Description:  json转map  
	* @return Map    返回类型  
	* @author li chao
	* @throws  
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map json2map(String json,Feature... features){ 
	    Map map = (Map)JSON.parse(json,features); 
	    return map;
	  } 
	
	
	@SuppressWarnings({ "rawtypes" })
	public static Map json2map(String json){ 
	    Map map = (Map)JSON.parse(json); 
	    return map;
	  } 
	
	/**
	 * 
	* @Title: map2json  
	* @Description:   map转json 
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	@SuppressWarnings("rawtypes")
	public static String map2json(Map map,SerializeFilter[] filters,SerializerFeature... features){ 
		return  JSON.toJSONString(map,filters,features); 
	  } 
	
	
	@SuppressWarnings("rawtypes")
	public static String map2json(Map map){ 
		return  JSON.toJSONString(map); 
	  } 
	
	/**
	 * 
	* @Title: object2json  
	* @Description:    对象转json
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static String object2json(Object obj,SerializeFilter[] filters,SerializerFeature... features){ 
		 String json= JSON.toJSONString(obj,filters,features);
	    return json;
	  } 
	
	
	
	public static String object2json(Object obj){ 
		 String json= JSON.toJSONString(obj);
	    return json;
	  } 
	
	/**
	 * 
	* @Title: json2object  
	* @Description:   json转对象
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static Object json2object(String jsonString,Feature... features){ 
			return JSON.parse(jsonString,features);
	  }
	
	
	public static Object json2object(String jsonString){ 
		return JSON.parse(jsonString);
	}
	
	
	public static <T> T json2object(String jsonString,Class<T> clazz){ 
		return JSON.parseObject(jsonString, clazz);
	}
}
