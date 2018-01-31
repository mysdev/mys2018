/**
 * 
 */
package com.jing.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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
	* @Title: getDateYyyyMM  
	* @Description: 获取当前日期（yyyy-MM）   
	* @return String    返回类型  
	* @author li chao
	* @throws  
	 */
	public static final String getDateYyyyMM(){
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM"); 
		String currdate=format.format(cal.getTime()); 
		return currdate;
	}
	
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
		return zonedDatetime.toInstant().atZone(ZoneId.of("+08:00")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * 比较2个时间大小
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取传入日期加减天数的日期
	 * @param specifiedDay yy-MM-dd hh:mm:ss
	 * @param count  天数
	 * @param X  +或-
	 * @return
	 */
	public static String getSpecifiedDay(String specifiedDay,int count,String x){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd hh:mm:ss").parse(specifiedDay); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		if(x.equals("+")){
			c.set(Calendar.DATE,day+count); 
		}else{
			c.set(Calendar.DATE,day-count); 
		}

		String dayAfter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(c.getTime()); 
		return dayAfter; 
		}  
	
		/**
		 * date转String
		 * @param date
		 * @return
		 */
		public static String DateToString (Date date){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			String str=sdf.format(date);  
			return str;
		}

		/** 
		* @Title: getDayCount 
		* @Description: 比较两个日期的间隔天数--不精确小时 0点算1天
		* @param fromDate 起始时间 强制为0点0分0秒
		* @param toDate 结束时间 强制为0点0分0秒
		* @param isWeekend 包括周末 true是 false否
		* @return  Integer    返回类型 
		* @throws 
		*/
		public static Integer getDayCount(Date fromDate, Date toDate, boolean isWeekend) {
			if(fromDate==null){
				fromDate = new Date();
			}
			if(toDate==null){
				toDate = new Date();
			}
			if(fromDate.getTime()>toDate.getTime()){
				Long t = fromDate.getTime();
				fromDate.setTime(toDate.getTime());
				toDate.setTime(t);
			}
			Calendar calStart = Calendar.getInstance();
			calStart.setTime(fromDate);
			calStart.set(Calendar.HOUR_OF_DAY, 0); //时  
			calStart.set(Calendar.MINUTE, 0);//分  
			calStart.set(Calendar.SECOND, 0);//秒  
			
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(toDate);
			calEnd.set(Calendar.HOUR_OF_DAY, 0); //时  
			calEnd.set(Calendar.MINUTE, 0);//分  
			calEnd.set(Calendar.SECOND, 0);//秒  
			//System.out.println("fromDate:"+getDateTime(calStart.getTime()));
			//System.out.println("toDate:"+getDateTime(calEnd.getTime()));
			int days = 1+(int) ((calEnd.getTimeInMillis() - calStart.getTimeInMillis()) / (1000*3600*24));
			//System.out.println("差:"+days);
			if(!isWeekend){
				int totalDay = 0; //补量
				int endCount = 0; //补工作日
				
				int fromWeek = calStart.get(Calendar.DAY_OF_WEEK) - 1;  //开始礼拜
				//System.out.println("fromWeek:"+fromWeek);			
				int toWeek = calEnd.get(Calendar.DAY_OF_WEEK) - 1;  //结束礼拜
				//System.out.println("toWeek:"+toWeek);
				//补到周一
				if(fromWeek==0){
					totalDay += 6; //周日
					endCount +=5;
				}else{
					totalDay+=(fromWeek-1); 
					if(fromWeek==6){
						endCount+=5;
					}else{
						endCount+=(fromWeek-1);
					}
				}
				//System.out.println("开始补天:"+totalDay+" 补工作日:"+endCount);
				//补到周日
				if(toWeek!=0){
					totalDay+=(7-toWeek); 
					if(toWeek!=6){
						endCount+=(5-toWeek);
					}
				}
				//System.out.println("结束补天:"+totalDay+" 补工作日:"+endCount);
				//（补量+原始+周次补)/7天每周*5工作日-补工作日
				//System.out.println("共:"+(tem)+"天 合"+(tem2)+"周 合"+(tem3)+"工作日");
				days = ((totalDay+days)/7*5)-endCount;				
			} 
			return days;
		}
		
		

		
		/** 
		* @Title: getCalendar 
		* @Description: 根据年月返回日期
		* @param yearMonth
		* @return
		* @throws ParseException  Calendar    返回类型 
		* @throws 
		*/
		public static Calendar getCalendar(String yearMonth) throws ParseException{
			yearMonth = yearMonth+"-01";		
			SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(yearMonth);
			Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        return cal;
		}
		
		/** 
		* @Title: is20yyMM 
		* @Description: 判断日期是否20yyMM
		* @param ymd
		* @return  boolean    返回类型 
		* @throws 
		*/
		public static boolean is20yyMM(String ymd){
			String regEx = "^20\\d\\d-(0\\d|11|12)$";
			Pattern pattern = Pattern.compile(regEx);
			return pattern.matcher(ymd).matches();
		}
	
}
