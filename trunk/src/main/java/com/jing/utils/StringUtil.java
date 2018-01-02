package com.jing.utils;

import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName: StringUtil  
 * @Description: 字符串工具类（需要逐步完善）
 * @author li chao
 * @date 2016年3月15日 下午4:31:34   @version V1.0  
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

	/**
	 * @Title: stringReplace  
	 * @Description: 正则表达式替换字符串 
	 * @param string
	 *            源字符串
	 * @param regEx
	 *            正则表达式
	 * @param replacement
	 *            新内容
	 * @return String    返回新字符串  
	 */
	public static String stringReplace(String string, String regEx, String replacement) {
		return string.replaceAll(regEx, replacement);
	}

	/**
	 * @Title: clearHTMLToString  
	 * @Description: 清理html
	 * @return String  返回新字符串
	 * @author li chao
	 */
	public static String clearHTMLToString(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		str = StringEscapeUtils.escapeHtml4(str);
		return str;
	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * @Title: isInteger  
	 * @Description: 判断是否为整数
	 * @return boolean    返回类型  
	 * @author li chao @throws  
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/** 
	* @Title: isNumeric 
	* @Description: 判断是否为整数
	* @param str
	* @return  boolean    返回类型 
	* @author Jinlong He
	* @throws 
	*/
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}

	/**
	 * @Title: getRandomString  
	 * @Description: 生成数字字符串 
	 * @return String
	 * @author li chao
	 */
	public static String getRandomString(int size) {
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < size; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * @Title: entityToString  
	 * @Description:Entity对象toString()的通用处理,用json方式显示各属性值 
	 * @param obj
	 * @return String    返回对象转成json后的字符串 
	 * @author liwenchao
	 */
	public static String entityToString(Object obj) {
		SerializerFeature[] fmtConfig = new SerializerFeature[] { SerializerFeature.PrettyFormat, // 格式化排版
				SerializerFeature.UseSingleQuotes, // 使用单引号
				SerializerFeature.SortField, // 排序
				SerializerFeature.WriteDateUseDateFormat }; // 日期格式yyyy-MM-dd
															// HH:mm:ss
		String str = MessageFormat.format("{0}:{1}", obj.getClass().getSimpleName(), JSON.toJSONString(obj, fmtConfig));
		return str;
	}

	/**
	 * 
	 * @Title: toLowerCaseFirstOne @Description: 首字母转小写 @param s @return String
	 *         返回类型 @throws
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 
	 * @Title: toUpperCaseFirstOne @Description: 首字母转大写 @param s @return String
	 *         返回类型 @throws
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 
	* @Title: replaceBr 
	* @Description: 替换换行符 
	* @param str
	* @return String
	* @author: li chao
	 */
	public static String replaceBr(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\r\n|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
}
