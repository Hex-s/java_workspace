package com.niit.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CommonUtil {
	public static String formatDate(Timestamp date){
		
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date != null){
			return formator.format(date);
		}
		return null;
	}
	
	public static String formatBirthday(Timestamp birth){
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
		if(birth != null){
			return formator.format(birth);
		}
		return null;
	}

}
