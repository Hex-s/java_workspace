package com.niit.exam6;
/**
 * 金钱超出上限异常
 * @author Administrator
 *
 */
public class MoneyOutOfBoundsException extends Exception {
	public MoneyOutOfBoundsException(String msg){
		super(msg);
	}
}
