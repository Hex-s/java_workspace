package com.niit.ui;

import javax.swing.JFrame;

import com.niit.util.CommonUtil;
/**
 * ������
 * @author Administrator
 *
 */
public class MainFrame extends JFrame {
	private LoginFrame loginFrm;
	public MainFrame(LoginFrame loginFrm){
		//��ȡ���촫��ĵ�½����
		this.loginFrm = loginFrm;
		//�������
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setResizable(false);
		//this.setTitle(CommonUtil.loginName+" ��½��");
		this.setTitle(loginFrm.getTxtName().getText()+" ��½��");
	}
}
