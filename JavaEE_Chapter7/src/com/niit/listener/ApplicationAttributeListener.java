package com.niit.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
/**
 * 监听application数据读写的监听器
 * @author Administrator
 *
 */
public class ApplicationAttributeListener implements ServletContextAttributeListener {

	/**
	 * 数据写入事件
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("添加了新的数据");
		//System.out.println("添加数据的键是："+event.getName()+",值是："+event.getValue());
		
	}
	/**
	 * 数据移除事件
	 */
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("移除了数据");
	}
	/**
	 * 数据替换事件
	 */
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("数据被替换");
		
	}

}
