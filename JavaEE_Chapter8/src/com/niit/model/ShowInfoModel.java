package com.niit.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

public class ShowInfoModel implements IModel {

	public String execute(HttpServletRequest request,
		HttpServletResponse response) {
		//��ȡ��Ʒ���
		int wareId = Integer.parseInt(request.getParameter("wareId"));
		WareDao wareDao = new WareDao();
		//���ݱ�Ų�ѯ��Ʒ��Ϣ
		Ware ware = wareDao.findWareById(wareId);
		//����Ʒ��Ϣ������������
		request.setAttribute("ware", ware);
		return "WEB-INF/info.jsp";
	}

}
