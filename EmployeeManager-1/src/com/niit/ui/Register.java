package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.niit.dao.impl.UserDao;
import com.niit.entity.User;

public class Register extends JFrame {
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblConfirmpwd;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmpwd;
	private JButton btnCancle;
	private JButton btnRegist;
	private UserDao userDao;
	private Login logFrm;
	
	public Register(Login logFrm){
		this.logFrm = logFrm;
		userDao =logFrm.getUserDao();
		//窗体初始化
		initFrame();
		//组件初始化
		initComponent();
		//绑定监听器
		bindListener();
	}
	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		BtnListener btnListener = new BtnListener();
		btnRegist.addActionListener(btnListener);
		btnCancle.addActionListener(btnListener);
		
	}
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnRegist){
				//用户名
				String userName = txtName.getText().trim();
				//密码
				String pwd = txtPassword.getText().trim();
				//确认密码
				String confirmPwd = txtConfirmpwd.getText().trim();
				//判断用户名是否为空
				if(userName.equals("")){
					JOptionPane.showMessageDialog(null, "请填写用户名！");
					txtName.requestFocus();
					return;
				}
				//判断密码是否为空
				if(pwd.equals("")){
					JOptionPane.showMessageDialog(null, "请填写密码！");
					txtPassword.requestFocus();
					return;
				}
				//判断确认密码是否为空
				if(confirmPwd.equals("")){
					JOptionPane.showMessageDialog(null, "请填写确认密码！");
					txtConfirmpwd.requestFocus();
					return;
				}
				//判断密码和确认密码是否一致
				if(pwd.equals(confirmPwd)){
					User user  = userDao.findUserByName(txtName.getText().trim());
					//用户已存在
					if(user != null){
						JOptionPane.showMessageDialog(null, "用户名已存在！");
						txtName.requestFocus();
						txtName.selectAll();
					}
					else{
						User newUser = new User(txtName.getText().trim(),txtPassword.getText().trim());
						boolean flag = userDao.saveUser(newUser);
						if(flag){
							JOptionPane.showMessageDialog(null, "注册成功！");
							Register.this.dispose();
							logFrm.setVisible(true);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "密码与确认密码不一致！");
					txtPassword.requestFocus();
					txtPassword.selectAll();
				}
			}
			else{
				Register.this.dispose();
				logFrm.setVisible(true);
			}
			
		}
		
	}
	/**
	 * 组件初始化
	 */
	private void initComponent() {
		lblName = new JLabel("用户名");
		lblPassword = new JLabel("密码");
		lblConfirmpwd = new JLabel("确认密码");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		txtConfirmpwd = new JPasswordField();
		btnCancle = new JButton("取消");
		btnRegist = new JButton("注册");
		//设置组件的大小和位置
		lblName.setBounds(80, 40, 60, 20);
		lblPassword.setBounds(80, 80,60, 20);
		lblConfirmpwd.setBounds(80, 120, 60, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		txtConfirmpwd.setBounds(150, 120, 140, 20);
		btnRegist.setBounds(130, 170, 60, 20);
		btnCancle.setBounds(200, 170, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblConfirmpwd);
		this.add(txtName);
		this.add(txtPassword);
		this.add(txtConfirmpwd);
		this.add(btnCancle);
		this.add(btnRegist);	
		
	}
	/**
	 * 窗体初始化
	 */
	private void initFrame() {
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("注册界面");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置为null布局
		this.setLayout(null);
		this.setResizable(false);	
	}

}
