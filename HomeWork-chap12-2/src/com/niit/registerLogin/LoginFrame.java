package com.niit.registerLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	
	private JLabel[] lbls;
	private String[] lblArray;
	private JTextField txtName;
	private JTextField txtPwd;
	private JTextField txtCode;
	private JLabel lblcode;
	private JButton btnRigister;
	private JButton btnLogin;
	
	
	public LoginFrame(){
		//窗体设置
		this.setTitle("用户登录");
		this.setBounds(400, 100, 400, 400);
		//空布局
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		
	}

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//实例化标签
		lbls = new JLabel[3];
		lblArray = new String[]{"用户名","密码","验证码"};
		for(int i = 0,y = 30; i < lbls.length; i++,y+=60){
			lbls[i] = new JLabel(lblArray[i]);
			lbls[i].setBounds(50, y, 60, 20);
			this.add(lbls[i]);
		}
		//实例化姓名文本框
		txtName = new JTextField();
		txtName.setBounds(130, 30, 120, 20);
		this.add(txtName);
		//实例化密码文本框
		txtPwd = new JTextField();
		txtPwd.setBounds(130, 90, 120, 20);
		this.add(txtPwd);
		//实例化验证码文本框
		txtCode = new JTextField();
		txtCode.setBounds(130, 150, 120, 20);
		this.add(txtCode);
		//实例化验证码
		lblcode = new JLabel(sysCode());
		lblcode.setBounds(260, 150, 50, 20);
		this.add(lblcode);
		
		//实例化注册按钮
		btnRigister = new JButton("注册");
		btnRigister.setBounds(100, 220, 70, 25);
		this.add(btnRigister);
		//实例化登录按钮
		btnLogin = new JButton("登录");
		btnLogin.setBounds(200, 220, 70, 25);
		this.add(btnLogin);
		
		buttonListener btnListener = new buttonListener();  
		btnLogin.addActionListener(btnListener);
		btnRigister.addActionListener(btnListener);
		
	}
	
	public class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton btn = (JButton)obj;
			if(btn == btnRigister){
//				LoginFrame.this.setVisible(false);
				LoginFrame.this.dispose();
				RegistFrame frm = new RegistFrame();
				frm.setVisible(true);

			}
			
		}
		
	}
	/**
	 * 产生4位验证码的方法
	 * @return
	 */
	public String sysCode(){
		String str = "";
		int random = 0;
		//随机产生一个0-9的数字
		for(int i = 1; i <=4; i++){
			random = (int)(Math.random() * 10);
			str += random;
		}
		return str;
	}

}
