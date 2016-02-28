 package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.niit.bean.User;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;

public class RegistFrame extends JFrame {

	private JLabel[] lbls;
	private String[] lblArray;
	private JTextField txtName;
	private JPasswordField txtPwd;
	private JPasswordField txtConfirmPwd;
	private JButton btnRegist;
	private JButton btnClose;
	//用户数据操作对象
	private UserDao userDao;
	private LoginFrame loginFrm;
	
	public RegistFrame(LoginFrame loginFrm){
		this.loginFrm = loginFrm;
		
		//将数据库实例化
		userDao = new UserDao(loginFrm.getData());
		//初始化窗口
		initFrame();
		//初始化组件
		initComponent();
		//绑定监听器
		bandListener();
		//设置窗体的默认回车按钮
		this.getRootPane().setDefaultButton(btnRegist);
	}
	/**
	 * 绑定监听器
	 */
	private void bandListener() {
		
		//按钮监听器
		ButtonListener btnListner = new ButtonListener();
		btnClose.addActionListener(btnListner);
		btnRegist.addActionListener(btnListner);
		
	}
	/**
	 * 初始化窗口
	 */
	private void initFrame(){
		//窗体设置
		this.setTitle("用户注册");
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);
		//空布局
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){ 
		//实例化标签
		lbls = new JLabel[3];
		lblArray = new String[]{"用户名","密码","确认密码"};
		for(int i = 0, y = 30; i < lbls.length; i++,y+=60){
			lbls[i] = new JLabel(lblArray[i]);
			//设置标签的大小和定位
			lbls[i].setBounds(50, y, 60, 20);
			this.add(lbls[i]);
		}
		//实例化文本框
		txtName = new JTextField();
		txtName.setBounds(130, 30, 120, 20);
		this.add(txtName);
		//密码框
		txtPwd = new JPasswordField();
		txtPwd.setBounds(130, 90, 120, 20);
		this.add(txtPwd);
		//确认密码
		txtConfirmPwd = new JPasswordField();
		txtConfirmPwd.setBounds(130, 150, 120, 20);
		this.add(txtConfirmPwd);
		
		//按钮
		btnRegist = new JButton("注册");
		btnClose = new JButton("关闭");
		btnRegist.setBounds(100, 250, 70, 25);
		btnClose.setBounds(220, 250, 70, 25);
		this.add(btnRegist);
		this.add(btnClose);
		
	}
	
	/**
	 * 注册  取消 按钮
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean isSelected = false;
			Object obj = e.getSource();
			JButton btn = (JButton)obj;
			if(btn == btnClose){
				RegistFrame.this.dispose();
			}
			//注册按钮
			if(btn == btnRegist){
				//获取文本框中输入的用户名
				String userName = txtName.getText().trim();
				//获取文本框中输入的密码
				String pwd = txtPwd.getText().trim();
				//获取文本框中输入的确认密码
				String confirmpwd = txtConfirmPwd.getText().trim();
				//判断用户名是否为空
				if(userName.equals("")){
					JOptionPane.showMessageDialog(null, "请填写用户名！");
					txtName.requestFocus();
					return;
				}
				//判断密码是否为空
				if(pwd.equals("")){
					JOptionPane.showMessageDialog(null, "请填写密码！");
					txtPwd.requestFocus();
					return;
				}
				//判断确认密码是否为空
				if(confirmpwd.equals("")){
					JOptionPane.showMessageDialog(null, "请填写确认密码");
					txtConfirmPwd.requestFocus();
					return;
				}
				
				//判断密码和确认密码是否一致
				if(!pwd.equals(confirmpwd)){
					JOptionPane.showMessageDialog(null, "密码和确认密码不一致！");
					txtConfirmPwd.requestFocus();
					txtConfirmPwd.selectAll();
					return;
				}
				//判断用户是否已经存在
				User user = userDao.findUserByName(txtName.getText().trim());
				if(user == null){
					//实例化新的用户
					User newUser = new User(userName, pwd, 0, false);
					//添加新用户
					userDao.add(newUser);
					JOptionPane.showMessageDialog(null, "注册成功！");
					//实例化登录界面
					loginFrm.setVisible(true);
					RegistFrame.this.dispose();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "用户名已存在！");
				}
			}
			//关闭按钮
			else{
				loginFrm.setVisible(true);
				RegistFrame.this.dispose();
			}
		}
		
	}
	
	
}
