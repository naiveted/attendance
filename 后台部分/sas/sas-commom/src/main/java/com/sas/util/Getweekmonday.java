/**   
 * @Title: Getweekmonday.java 
 * @Package com.appointment.util 
 * @Description: TODO(用一句话描述该文件做什么)
 */
package com.sas.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: Getweekmonday
 * @Description: TODO(获取时间)
 */
public class Getweekmonday {
	public Date getNowWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	// 获得当前日期与本周日相差的天数  
	private  int getMondayPlus(Date gmtCreate) {  
	    Calendar cd = Calendar.getInstance();  
	    cd.setTime(gmtCreate);  
	    // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......  
	    int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1  
	    if (dayOfWeek == 1) {  
	        return 0;  
	    } else {  
	        return 1 - dayOfWeek;  
	    }  
	}  
	  
	// 获得下周星期一的日期  
	public  Date getNextMonday(Date gmtCreate) {  
	    int mondayPlus = getMondayPlus(gmtCreate);  
	    GregorianCalendar currentDate = new GregorianCalendar();  
	    currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);  
	    Date monday = currentDate.getTime();  
	    return monday;  
	}  
}
