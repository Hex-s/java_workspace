package com.niit.tag;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class MySetPropertyTag extends TagSupport{
	
	private String property;
	private String name;
	private Object value;
	
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	
	@Override
	public int doStartTag() throws JspException {
		Object obj = null;
		
		if(pageContext.getAttribute(name) != null){		
				obj =pageContext.getAttribute(name);				
		}
		else if(pageContext.getRequest().getAttribute(name)!=null){			
				obj =pageContext.getRequest().getAttribute(name);			
		}
		else if(((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(name)!=null){			
				obj =((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(name);			
		}
		else if(pageContext.getServletContext().getAttribute(name)!=null){			
				obj =pageContext.getServletContext().getAttribute(name);			
		}
		if(obj!=null){
			//获取反射的所有方法
			Method[] methods = obj.getClass().getDeclaredMethods();
			//遍历所有方法与property属性进行匹配
			for(int i = 0;i<methods.length;i++){
				if(methods[i].getName().equalsIgnoreCase("set"+property)){
					try {
						methods[i].invoke(obj, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return super.doStartTag();
	}

	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	

}
