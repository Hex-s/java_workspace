package com.niit.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * �ַ���ת���Ĺ�����
 * @author Administrator
 *
 */
public class EncodeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		//System.out.println("����encode filter");
		//�ж�����ķ�ʽ
		//post����
		if(request.getMethod().equalsIgnoreCase("post")){
			request.setCharacterEncoding("utf-8");
		}
		//get����
		else{
			//��ȡ�����е����в���
			Enumeration<String> keys = request.getParameterNames();
			//����
			while(keys.hasMoreElements()){
				//��ȡÿһ������
				//String values = request.getParameter(keys.nextElement());
				//�Բ��������ַ����ع�
				//value = new String(value.getBytes("iso-8859-1"),"utf-8");
				//System.out.println(value);
				String[] values = request.getParameterValues(keys.nextElement());
				for(int i = 0; i < values.length; i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		//������������
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
