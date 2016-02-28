package com.niit.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.omg.CORBA.Request;

public class MyUseBeanTag extends TagSupport {
	private String id;
	private String className;
	private String scope;
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		//获取id和 className
		//根据className创建对象的实例
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//根据id将实例对象写入作用域
		//判断scope是否有值
		if(scope == null){
			//如果 scope没有填写，则默认为pageContext
			pageContext.setAttribute(id, obj);
		}
		else if(scope.equals("page")){
			pageContext.setAttribute(id, obj);
		}
		else if(scope.equals("request")){
			pageContext.getRequest().setAttribute(id, obj);
		}
		else if(scope.equals("session")){
			((HttpServletRequest)pageContext.getRequest()).getSession().setAttribute(id, obj);
		}
		else if(scope.equals("application")){
			pageContext.getServletContext().setAttribute(id, obj);
		}
		
		
		
		return super.doStartTag();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
