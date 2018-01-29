/**
 * 
 */
package com.jing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**  
 * @ClassName: DateUtil  
 * @Description: 日期处理类（需要逐步完善）
 * @author li chao
 * @date 2015年11月26日 上午10:42:58 
 * @version V1.0  
 */
public class DateUtil {

	/**
	 * 
	* @Title: getDate  
	* @Description: 获取当前日期（yyyy-MM-dd）   
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static final String getDate(){
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
		String currdate=format.format(cal.getTime()); 
		return currdate;
	}
	
	/**
	 * 
	* @Title: getDateTime  
	* @Description: 获取当前日期（yyyy-MM-dd HH:mm:ss）     
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static final String getDateTime(){
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String currdate=format.format(cal.getTime()); 
		return currdate;
	}
	
	
	/**
	 * 
	* @Title: getTime  
	* @Description: 获取当前时间（HH:mm:ss）     
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static final String getTime(){
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat format = new java.text.SimpleDateFormat("HH:mm:ss"); 
		String currdate=format.format(cal.getTime()); 
		return currdate;
	}
	
	/**
	 * 
	* @Title: String2DateTime  
	* @Description: 获取当前时间（HH:mm:ss）     
	* @return Date    返回类型  
	* @author li chao
	 * @throws ParseException 
	* @throws  
	 */
	public static final Date String2DateTime(String dateTime) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = sdf.parse(dateTime);
		return date;
	}
	
	/**
	 * 
	* @Title: String2Date
	* @Description: 获取当前时间（HH:mm:ss）     
	* @return Date    返回类型  
	* @author li chao
	 * @throws ParseException 
	* @throws  
	 */
	public static final Date String2Date(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
	    Date date1 = sdf.parse(date);
		return date1;
	}
	
	/**
	 * 时区转换
	 * @param changedTime
	 * @return
	 */
	public static final String changedChinaDate(String changedTime){
		ZonedDateTime zonedDatetime = ZonedDateTime.parse(changedTime);
		String s = zonedDatetime.toInstant().atZone(ZoneId.of("+08:00")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return s;
	}
	
}
