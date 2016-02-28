package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	public static String formatDate(Date date){
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(date != null){
			return formator.format(date);
		}
		return null;
	}
}
