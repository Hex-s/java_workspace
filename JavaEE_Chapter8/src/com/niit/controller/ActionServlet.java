package com.niit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.model.AddWareModel;
import com.niit.model.IModel;
import com.niit.model.LoginModel;
import com.niit.model.ShoppingCarModel;
import com.niit.model.ShowAllWareModel;
import com.niit.model.ShowInfoModel;
/**
 * 核心控制器，用以接受所有客户端请求，并分发给不同模型实现业务逻辑处理
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求路径
		String value = req.getRequestURI();
		int sindex = value.lastIndexOf('/');
		int eindex = value.lastIndexOf('.');
		value = value.substring(sindex+1, eindex);
		//根据请求附带的键值数据分发给不同的业务模型进行处理
		IModel model = (IModel)getServletContext().getAttribute(value);
		//调用模型的处理业务逻辑的方法
		String url = model.execute(req,resp);
		//服务器的响应
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext application = getServletContext();
		//添加登录的模型
		application.setAttribute("login", new LoginModel());
		//添加查询所有商品信息的模型
		application.setAttribute("init", new ShowAllWareModel());
		//添加查询商品信息的模型
		application.setAttribute("showInfo", new ShowInfoModel());
		//添加购物车模型
		application.setAttribute("addWare", new AddWareModel());
		//添加查阅购物车模型
		application.setAttribute("myCar", new ShoppingCarModel());
	}
	
}
