package com.niit.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
/**
 * ����application���ݶ�д�ļ�����
 * @author Administrator
 *
 */
public class ApplicationAttributeListener implements ServletContextAttributeListener {

	/**
	 * ����д���¼�
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("������µ�����");
		//System.out.println("������ݵļ��ǣ�"+event.getName()+",ֵ�ǣ�"+event.getValue());
		
	}
	/**
	 * �����Ƴ��¼�
	 */
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("�Ƴ�������");
	}
	/**
	 * �����滻�¼�
	 */
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("���ݱ��滻");
		
	}

}
