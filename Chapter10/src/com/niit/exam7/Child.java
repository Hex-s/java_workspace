package com.niit.exam7;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.processing.FilerException;

public class Child extends Base {

	/**
	 * 普通方法中声明的异常类型不能低于抛出的异常类型
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public void childMethod() throws IOException,NullPointerException,Exception{
		// TODO Auto-generated method stub
		super.method();
	}
	/**
	 * 子类重写父类方法时，不能抛出比父类更多的异常类型
	 * 一个方法可以同时声明抛出多个异常
	 */
	public void method() throws FileNotFoundException, FilerException{
		
	}

	
}
