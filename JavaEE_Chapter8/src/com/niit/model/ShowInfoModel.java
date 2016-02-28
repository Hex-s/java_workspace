package com.niit.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

public class ShowInfoModel implements IModel {

	public String execute(HttpServletRequest request,
		HttpServletResponse response) {
		//获取商品编号
		int wareId = Integer.parseInt(request.getParameter("wareId"));
		WareDao wareDao = new WareDao();
		//根据编号查询商品信息
		Ware ware = wareDao.findWareById(wareId);
		//将商品信息添加至请求对象
		request.setAttribute("ware", ware);
		return "WEB-INF/info.jsp";
	}

}
