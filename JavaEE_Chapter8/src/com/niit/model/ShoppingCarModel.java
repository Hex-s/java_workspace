package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Record;
import com.niit.util.CommonUtil;

public class ShoppingCarModel implements IModel {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//获取购物车
		ArrayList<Record> list = (ArrayList<Record>)request.getSession().getAttribute(IModel.SHOPPINGCAR);
		//总价
		double totalPrice = 0;
		for(Record record : list){
			//System.out.println(record.getPrice());
			//累计总价
			totalPrice+=record.getPayPrice();
			
		}
		//写入总价
		request.setAttribute("totalPrice", totalPrice);
		return "WEB-INF/car.jsp";
	}

}
