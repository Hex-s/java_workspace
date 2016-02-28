package com.niit.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

/**
 * ��ʾ������Ʒ��Ϣ��ģ��
 * @author Administrator
 *
 */
public class ShowAllWareModel implements IModel {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		WareDao wareDao = new WareDao();
		//��ѯ������Ʒ
		ArrayList<Ware> list = wareDao.findAll();
		//����Ϣ��������
		request.setAttribute("wareList", list);
		return "WEB-INF/allWare.jsp";
	}

}
