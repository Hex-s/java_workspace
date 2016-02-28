package com.niit.listener;

import java.util.ArrayList;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.niit.bean.Record;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		//�������ﳵ����
		ArrayList<Record> list = new ArrayList<Record>();
		//�����ﳵ����session
		se.getSession().setAttribute("shoppingCar", list);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
