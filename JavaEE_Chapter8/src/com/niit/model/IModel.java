package com.niit.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ģ�ͽӿ�
 * @author Administrator
 *
 */
public interface IModel {
	public static final String SHOPPINGCAR = "shoppingCar";
	/**
	 * ����ҵ���߼��ķ���
	 * @param request
	 * @param response
	 * @return ��Ӧ�ؿͻ��˵�ҳ��URL
	 */
	public String execute(HttpServletRequest request,HttpServletResponse response);
}
