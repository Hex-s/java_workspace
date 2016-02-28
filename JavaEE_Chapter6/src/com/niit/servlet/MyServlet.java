package com.niit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * �Զ���servlet
 * @author Administrator
 *
 */
public class MyServlet extends HttpServlet{

	/**
	 * ����get����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("������get����");
		//super.doGet(req, resp);
		doPost(req, resp);
	}
	/**
	 *  ����post����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("������post����");
		//��ȡ��ǰservlet��name
		System.out.println(getServletName());
		//��ȡ��ǰservlet�������Ķ���
		//�ö����൱��jsp�е�application����
		ServletContext context = getServletContext();
		//��ȡsession
		HttpSession session = req.getSession();
		//��ȡȫ�ֲ���
		String value = context.getInitParameter("key");
		System.out.println(value);
		//��ȡ�ֲ�����
		String encode = getInitParameter("encode");
		System.out.println(encode);
		//��ȡ��Ŀ�ĸ�·��
		String path = context.getContextPath();
		System.out.println(path);
		//��ȡ��ǰ��Ŀ���ڷ������ľ���·��
		String realPath = context.getRealPath("/");
		System.out.println(realPath);
		//req.getRequestDispatcher("success.jsp").forward(req, resp);
		resp.setCharacterEncoding("gbk");
		//��ȡ�����
		PrintWriter out = resp.getWriter();
		out.write("������myServlet");	
	}
	/**
	 * servlet�ĺ��ķ����������Կͻ��˵����������Ӧ���ڸ÷����л����doGet�Լ�doPost
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�����˿ͻ��˵����󣬲���ʼִ����Ӧ");
		super.service(request, response);
	}
	/**
	 * ���ٷ���
	 */
	@Override
	public void destroy() {
		System.out.println("servlet������");
		super.destroy();
	}
	/**
	 * ��ʼ������
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("servlet��ʼ��");
		super.init();
	}
	
}
