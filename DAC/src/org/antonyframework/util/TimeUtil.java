/**
 * @Create Time：2010-7-9 上午10:35:08 
 * @author ZhouRongyu
 * © 2010-2015 SunCompany. All rights reserved
 */
package org.antonyframework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String dateToDatetime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(date);
		return time;
	}
	public static String dateToDatetimeDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String time = df.format(date);
		return time;
	}
	public static String dateToDatetimeMin(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
		String time = df.format(date);
		return time;
	}
	public static String dateToDatetimeMonth(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("MM");
		String time = df.format(date);
		return time;
	}
	public static String dateToDatetimetoDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("dd");
		String time = df.format(date);
		return time;
	}
	
	public static String dateToPointDatetime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd  hh:mm");
		String time = df.format(date);
		return time;
	}
	public static String DateFormatForAdvice(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("M月dd日 hh:mm");
		String time = df.format(date);
		return time;
	}
	
	public static String DateFormatForRound(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年  M月dd日   hh:mm");
		String time = df.format(date);
		return time;
	}
	
	public static String DateFormatForDay(Date d){
		SimpleDateFormat s = new SimpleDateFormat("yyyy年M月dd日");
		String time = s.format(d);
		return time;
	}
	public static String DateFormat(Date d){
		SimpleDateFormat s = new SimpleDateFormat("yyyy年M月dd日");
		SimpleDateFormat w = new SimpleDateFormat("F");
		SimpleDateFormat h = new SimpleDateFormat("hh:mm");
		String date = s.format(d);
		String week = w.format(d);
		String hour = h.format(d);
		switch (week.charAt(0)-48) {
		case 1:
			week="星期一";
			break;
		case 2:
			week="星期二";
			break;
		case 3:
			week="星期三";
			break;
		case 4:
			week="星期四";
			break;
		case 5:
			week="星期五";
			break;
		case 6:
			week="星期六";
			break;
		case 7:
			week="星期天";
			break;
		default:
			week="";
			break;
		}
		
		return date+"  "+week+"  "+hour;
	}
	public static String DateFormatForMessage(Date d){
		SimpleDateFormat s = new SimpleDateFormat("yyyy年M月dd日");
		SimpleDateFormat h = new SimpleDateFormat("hh:mm");
		String date = s.format(d);
		String hour = h.format(d);
		
		return date+""+hour;
	}
}
/* 使用TimeUtil.dateToDatetime(new Date()) */
