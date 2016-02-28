package com.niit.util;

import java.math.BigDecimal;

public class CommonUtil {

	/**
	 * 判断数值是否是浮点数
	 * @param num
	 * @return
	 */
	public static boolean isDouble(BigDecimal num){
		return num.toString().indexOf(".") != -1;
	}
}
