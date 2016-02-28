package com.niit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�������ı����ֵ
		String value = req.getParameter("txt");
		System.out.println(value);
		//�������ϴ洢�����������ַ���
		ArrayList<String> list = new ArrayList<String>();
		String[] array = new String[]{"application","session","request","response","cookie","jsp","service","struts","spring","hibernate"};
		//���������ҵ�ƥ����ַ���
		if(!value.equals("")){
			for(String s : array){
				if(s.indexOf(value) != -1){
					list.add(s);
				}
			}	
		}
		
		req.setAttribute("data", list);
		req.getRequestDispatcher("ajax/data.jsp").forward(req, resp);
	}
	
}
