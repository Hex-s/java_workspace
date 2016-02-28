package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

/**
 * 显示所有商品信息的模型
 * @author Administrator
 *
 */
public class ShowAllWareModel implements IModel {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		WareDao wareDao = new WareDao();
		//查询所有商品
		ArrayList<Ware> list = wareDao.findAll();
		//将信息存入请求
		request.setAttribute("wareList", list);
		return "WEB-INF/allWare.jsp";
	}

}
