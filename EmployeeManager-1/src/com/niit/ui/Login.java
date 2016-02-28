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

public class Login extends JFrame{
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnRegist;
	private UserDao userDao;
	
	public  Login(){
		userDao = new UserDao();
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
		BtnListener  btnListener = new BtnListener();
		btnLogin.addActionListener(btnListener);
		btnRegist.addActionListener(btnListener);
	}

	/**
	 * 初始化组件
	 */
	public void initComponent(){
		lblName = new JLabel("用户名");
		lblPassword = new JLabel("密码");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("登录");
		btnRegist = new JButton("注册");
		//设置组件的大小和位置
		lblName.setBounds(100, 40, 40, 20);
		lblPassword.setBounds(100, 80, 40, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		btnLogin.setBounds(130, 140, 60, 20);
		btnRegist.setBounds(200, 140, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(txtName);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(btnRegist);	
	}

	/**
	 *  窗体初始化
	 */
	private void initFrame(){
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("登录界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置为null布局
		this.setLayout(null);
		this.setResizable(false);	
	}
	
	
	/**
	 * 按钮监听器
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取按钮元素
			JButton btn = (JButton)e.getSource();
			//登陆
			if(btn == btnLogin){
				//用户名
				String userName = txtName.getText().trim();
				//密码
				String pwd = txtPassword.getText().trim();
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
				//判断用户是否存在
				User user = userDao.findUserByName(userName);
				if(user != null){
					//判断密码是否正确
					if(pwd.equals(user.getUserPwd())){
						//登陆成功，进入主界面
						MainFrame frm = new MainFrame(Login.this);
						frm.setVisible(true);
						//关闭登陆界面
						Login.this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "密码不正确！");
						txtPassword.requestFocus();
						txtPassword.selectAll();
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "用户不存在！");
					txtName.requestFocus();
					txtName.selectAll();
					return;
				}
			}
			//注册
			else{
				Register frm = new Register(Login.this);
				frm.setVisible(true);
				//隐藏登陆窗口
				Login.this.setVisible(false);
			}
			
		}
		
	}


	public UserDao getUserDao() {
		return userDao;
	}

	public JTextField getTxtName() {
		return txtName;
	}
	

}
