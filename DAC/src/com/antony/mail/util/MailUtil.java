package com.antony.mail.util;

public class MailUtil {
	public static String nullToHtml (String str) 
	{
		if (str == null)
			return "&nbsp;";
		else
			return  str;
	}
	public static String dateToHyphen1 ( String date ) 
	{  
		try{
			if ( date == null )  return "" ;
			else 
			{
				String temp="";
				date = date.substring(2);
				temp=date.substring(0,2)+"-";
				temp+=date.substring(2,4)+"-";
				temp+=date.substring(4);
				return temp  ;
			} 
		}catch(Exception ee){}
		return date;

	}
	
	public static String dateToHyphen ( String date ) 
	{  
		try{
			if ( date == null )  return "" ;
			else 
			{
				String temp="";
				temp=date.substring(0,4)+"-";
				temp+=date.substring(4,6)+"-";
				temp+=date.substring(6);
				return temp  ;
			} 
		}catch(Exception ee){}
		return date;

	}
}
