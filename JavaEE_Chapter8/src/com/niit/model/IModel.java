package com.niit.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模型接口
 * @author Administrator
 *
 */
public interface IModel {
	public static final String SHOPPINGCAR = "shoppingCar";
	/**
	 * 处理业务逻辑的方法
	 * @param request
	 * @param response
	 * @return 响应回客户端的页面URL
	 */
	public String execute(HttpServletRequest request,HttpServletResponse response);
}
