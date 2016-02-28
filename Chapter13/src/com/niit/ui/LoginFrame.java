package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.niit.bean.User;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class LoginFrame extends JFrame {
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblCheckCode;
	private JLabel lblCode;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtCheckCode;
	private JButton btnLogin;
	private JButton btnRegist;
	private String code;
	//用户数据操作对象
	private UserDao userDao;
	
	public LoginFrame(){
		//将数据库实例化
		Data data = new Data();
		userDao = new UserDao(data);
		//窗体初始化
		initFrame();
		//组件初始化
		initComponent();
		//绑定监听器
		bandListener();
		//设置窗体的默认回车按钮
		this.getRootPane().setDefaultButton(btnLogin);
	}
	public JTextField getTxtName() {
		return txtName;
	}
	/**
	 * 绑定监听器的方法
	 */
	private void bandListener(){
		btnLogin.addActionListener(new ButtonClickListener());
	}
	/**
	 *  窗体初始化
	 */
	private void initFrame(){
		this.setBounds(400, 300, 400, 250);
		this.setTitle("登录界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置为null布局
		this.setLayout(null);
		this.setResizable(false);	
	}
	/**
	 * 初始化组件
	 */
	public void initComponent(){
		lblName = new JLabel("用户名");
		lblPassword = new JLabel("密码");
		lblCheckCode = new JLabel("验证码");
		//产生验证码
		code = createCode();
		lblCode = new JLabel(code);
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		txtCheckCode = new JTextField();
		btnLogin = new JButton("登录");
		btnRegist = new JButton("注册");
		//设置组件的大小和位置
		lblName.setBounds(100, 40, 40, 20);
		lblPassword.setBounds(100, 80, 40, 20);
		lblCheckCode.setBounds(100, 120, 40, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		txtCheckCode.setBounds(150, 120, 90, 20);
		lblCode.setBounds(255, 120, 30, 20);
		btnLogin.setBounds(140, 160, 60, 20);
		btnRegist.setBounds(210, 160, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblCheckCode);
		this.add(txtName);
		this.add(txtPassword);
		this.add(txtCheckCode);
		this.add(lblCode);
		this.add(btnLogin);
		this.add(btnRegist);	
	}
	/**
	 * 产生验证码
	 * @return
	 */
	private String createCode(){
		Random random = new Random();
		String code = "";
		for(int i = 1; i <= 4; i++){
			int n = random.nextInt(10);
			code += n + "";
		}
		return code;
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取文本框输入的用户名
			String userName = txtName.getText().trim();
			//获取密码框输入的密码
			String password = txtPassword.getText().trim();
			//判断用户名是否为空
			if(userName.equals("")){
				JOptionPane.showMessageDialog(null, "请填写用户名！");
				//聚焦文本框
				txtName.requestFocus();
				return;
			}
			//判断密码是否为空
			if(password.equals("")){
				JOptionPane.showMessageDialog(null, "请填写密码！");
				//聚焦密码框
				txtPassword.requestFocus();
				return;
			}
			//判断用户名是否正确
			User user = userDao.findUserByName(userName);
			if(user != null){
				//判断密码
				if(user.getPassword().equals(password)){
					//窗体间传递数据方式一：通过静态变量传递
					//将用户名保存在静态变量中
					//CommonUtil.loginName = userName;
					//数据传递方式二：通过参数传递，窗体对象传递可以获取更多的信息
					//实例化主窗体
					MainFrame mainFrm = new MainFrame(LoginFrame.this);
					//呈现
					mainFrm.setVisible(true);
					//关闭当前窗体
					LoginFrame.this.dispose();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "密码错误！");
					txtPassword.requestFocus();
					txtPassword.selectAll();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "用户名不存在！");
				//聚焦
				txtName.requestFocus();
				//选中当前文本
				txtName.selectAll();
			}
		}
	}
	
	public static void main(String[] args) {
		LoginFrame frm = new LoginFrame();
		frm.setVisible(true);
	}
}
