package com.niit.exam7;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.processing.FilerException;

public class Child extends Base {

	/**
	 * ��ͨ�������������쳣���Ͳ��ܵ����׳����쳣����
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public void childMethod() throws IOException,NullPointerException,Exception{
		// TODO Auto-generated method stub
		super.method();
	}
	/**
	 * ������д���෽��ʱ�������׳��ȸ��������쳣����
	 * һ����������ͬʱ�����׳�����쳣
	 */
	public void method() throws FileNotFoundException, FilerException{
		
	}

	
}
