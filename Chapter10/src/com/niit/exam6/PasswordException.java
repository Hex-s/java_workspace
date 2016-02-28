package com.niit.exam6;
/**
 * 自定义异常
 * 密码异常类，继承自运行时异常
 * @author Administrator
 *
 */
public class PasswordException extends RuntimeException {
	
	public PasswordException(String msg){
		super(msg);
	}
}
