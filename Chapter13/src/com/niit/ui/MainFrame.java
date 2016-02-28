package com.niit.ui;

import javax.swing.JFrame;

import com.niit.util.CommonUtil;
/**
 * 主窗体
 * @author Administrator
 *
 */
public class MainFrame extends JFrame {
	private LoginFrame loginFrm;
	public MainFrame(LoginFrame loginFrm){
		//获取构造传入的登陆窗体
		this.loginFrm = loginFrm;
		//窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setResizable(false);
		//this.setTitle(CommonUtil.loginName+" 登陆中");
		this.setTitle(loginFrm.getTxtName().getText()+" 登陆中");
	}
}
