package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Record;
import com.niit.util.CommonUtil;

public class ShoppingCarModel implements IModel {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡ���ﳵ
		ArrayList<Record> list = (ArrayList<Record>)request.getSession().getAttribute(IModel.SHOPPINGCAR);
		//�ܼ�
		double totalPrice = 0;
		for(Record record : list){
			//System.out.println(record.getPrice());
			//�ۼ��ܼ�
			totalPrice+=record.getPayPrice();
			
		}
		//д���ܼ�
		request.setAttribute("totalPrice", totalPrice);
		return "WEB-INF/car.jsp";
	}

}
