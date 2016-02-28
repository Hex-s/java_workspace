package com.niit;

import javax.swing.JFrame;
/**
 * 通过继承的方式实现自定义窗体
 * @author Administrator
 *
 */
public class MyFrame extends JFrame {

	/**
	 * 通过构造方法对窗体进行初始化
	 */
	public MyFrame(){
		//设置标题
		setTitle("自定义窗体");
		//设置大小和位置
		setBounds(200, 200, 400, 400);
		//设置窗体的关闭策略
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
