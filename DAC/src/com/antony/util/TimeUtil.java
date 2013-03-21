package com.antony.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("HH:mm");

		try {
			Date d1 = df.parse("15:25");
			Date d2 = df.parse("15:27");
			long diff = d1.getTime() - d2.getTime();
			long days = diff / (1000 * 60 );
			System.out.println("ddd"+days);
		} catch (Exception e) {
		}
	}
}
