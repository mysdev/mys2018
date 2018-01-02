package com.jing.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.jing.utils.paginator.domain.Paginator;

/**
 * @ClassName: HttpResposeUtil
 * @Description: Controller类返回信息集中处理
 * @author: Jinlong He
 * @date: 2017年4月1日 上午8:39:26
 */
public class HttpResposeUtil {
	
	/**
	 * 
	* @Title: packageResposeInfo 
	* @Description: controller返回数据封装
	* @param response
	* @param ret service执行结果
	* @return Object
	* @author: li chao
	 */
	public static Object packageResposeInfo(HttpServletResponse response, Object ret){		
		return packageResposeInfo(response, HttpCodeEnum.HTTP_SUSESS, ret, null);
	}
	
	public static Object packageResposeInfo(HttpServletResponse response, HttpCodeEnum errorEnum, Object ret){		
		return packageResposeInfo(response, errorEnum, ret, null);
	}	
	
	@SuppressWarnings("rawtypes")
	public static Object packageResposeInfo(HttpServletResponse response, HttpCodeEnum errorEnum, Object ret, Map<String, String> errors){
		if(errorEnum!=null && errorEnum.getCode()<0){
			//异常情况
			return packageReturn(errorEnum, errors);
		}
		//以下操作正常但是数据为空的情况
		if(ret==null){
			response.setStatus(HttpCodeEnum.HTTP_NOT_FOUND.getCode());
			return packageReturn(HttpCodeEnum.HTTP_NOT_FOUND, errors);
		}		
		//数据不为空，但是内容为空的情况
		if(ret instanceof Map){
			//Map
			if(((Map)ret).isEmpty()){
//				response.setStatus(HttpErrorEnum.HTTP_NOTFOUND.getCode());
//				return packageReturn(HttpErrorEnum.HTTP_NOTFOUND, errors);
				//20170410 修订返回数据为空时，组装空数据返回
				Map<String, Object> ret1 = new HashMap<String, Object>();
				ret1.put(Constant.PAGELIST, null);
				ret1.put(Constant.PAGINATOR, new Paginator());
				return ret1;
			}
		}else if (ret instanceof Collection){
			//List Set
			if(((Collection)ret).isEmpty()){				
//				response.setStatus(HttpErrorEnum.HTTP_NOTFOUND.getCode()); 
//				return packageReturn(HttpErrorEnum.HTTP_NOTFOUND, errors);
				//20170410 修订返回数据为空时，组装空数据返回
				return "[]";
			}
		}else if(ret.getClass().isArray()){
			//数组
			if(((Object[])ret).length==0){
//				response.setStatus(HttpErrorEnum.HTTP_INVALID.getCode()); 
//				return packageReturn(HttpErrorEnum.HTTP_INVALID, errors);
				//20170410 修订返回数据为空时，组装空数据返回
				return "[]";
			}
		}else if(ret instanceof Integer){
			//Integer
			int temp = (Integer)ret;
			if(temp==0){
				response.setStatus(HttpCodeEnum.HTTP_NOT_FOUND.getCode()); 
				return packageReturn(HttpCodeEnum.HTTP_NOT_FOUND, errors);
			}else if(temp<0){
				//负数
				HttpCodeEnum en = HttpCodeEnum.getTypeByCode(-temp);
				response.setStatus(en.getCode()); 
				return packageReturn(en, errors);
			}
			
			ret = "{\"data\":\""+ret+"\"}";
		}else if(ret instanceof String){
			//String			
			ret = "{\"data\":\""+ret+"\"}";
		}
		
		//正常情况
		response.setStatus(HttpCodeEnum.HTTP_SUSESS.getCode());
		return ret;
	}
	
	private static Map<String, Object> packageReturn(HttpCodeEnum errorEnum, Map<String, String> errors){
		return packageReturn(errorEnum.getCode(), errorEnum.getMsg(), errors);
	}
	
	
	private static Map<String, Object> packageReturn(int code, String message, Map<String, String> errors){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("code", code);
		ret.put("msg", message);
		if(errors!=null && !errors.isEmpty())
			ret.put("errors", errors);
		return ret;
	}
}
