package com.niit.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 自定义标签类
 * @author Administrator
 *
 */
public class MyTag extends TagSupport {
	private String name;
	private int age;
	private JspWriter out;
	
	/**
	 * EVAL_PAGE表示当结束标签执行完后，继续执行页面中剩余的其他内容
	 * SKIP_PAGE表示当前结束标签执行后，同时结束整个页面的内容
	 */
	@Override
	public int doEndTag() throws JspException {
		System.out.println("执行了结束标签");
		return EVAL_PAGE;
	}

	/**
	 * SKIP_BODY表示跳过标签体的执行，当起始标签运行后直接执行结束标签
	 * EVAL_BODY_INCLUDE表示执行完开始标签后继续执行标签体内容，直至结束标签
	 */
	@Override
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		System.out.println("执行了开始标签");
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
