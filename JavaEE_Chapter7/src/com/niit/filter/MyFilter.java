package com.niit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	/**
	 *  ����������
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("������������");
	}
	/**
	 * ִ�й�����
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * ������ֻ�ܶ��ض���ĵ�ַ���й��ˣ�������ת�����ᴥ��������
		 * */
		System.out.println("ִ���˹��˶���");
		//��������ת��,��ԭ�������·������������ת
		chain.doFilter(request, response);
	}

	/**
	 * ��ʼ��������
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����������ʼ��");
		
	}

}
