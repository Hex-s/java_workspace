package com.niit.dao.util;

import java.math.BigDecimal;

public class CommonDaoUtil {

	/**
	 * �ж���ֵ�Ƿ��Ǹ�����
	 * @param num
	 * @return
	 */
	public static boolean isDouble(BigDecimal num){
		return num.toString().indexOf(".") != -1;
	}
}
