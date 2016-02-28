package com.niit.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * �Զ����ǩ��
 * @author Administrator
 *
 */
public class MyTag extends TagSupport {
	private String name;
	private int age;
	private JspWriter out;
	
	/**
	 * EVAL_PAGE��ʾ��������ǩִ����󣬼���ִ��ҳ����ʣ�����������
	 * SKIP_PAGE��ʾ��ǰ������ǩִ�к�ͬʱ��������ҳ�������
	 */
	@Override
	public int doEndTag() throws JspException {
		System.out.println("ִ���˽�����ǩ");
		return EVAL_PAGE;
	}

	/**
	 * SKIP_BODY��ʾ������ǩ���ִ�У�����ʼ��ǩ���к�ֱ��ִ�н�����ǩ
	 * EVAL_BODY_INCLUDE��ʾִ���꿪ʼ��ǩ�����ִ�б�ǩ�����ݣ�ֱ��������ǩ
	 */
	@Override
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		System.out.println("ִ���˿�ʼ��ǩ");
		try {
			
			out.print("<table border=1>");
			out.print("<tr>");
			out.print("<td><img src='image/head/1.gif' /></td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+age+"</td>");
			out.print("</tr>");
			out.print("</table>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
