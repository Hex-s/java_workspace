package com.niit.ui.stu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TeacherDao;
import com.niit.entiry.Student;
import com.niit.entiry.Teacher;
import com.niit.ui.teacher.TeaMainFrame;



public class LoginFrame extends JFrame{
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblType;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnCancle;
	private StudentDao stuDao;
	private TeacherDao teaDao;
	private ButtonGroup group;
	private JRadioButton[] rboType;
	private String[] type;
	private JLabel lblTitle;
	
	private Student loginStu;
	private Teacher loginTea;
	
	public  LoginFrame(){
		stuDao = new StudentDao();
		teaDao = new TeacherDao();
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
		btnLogin.addActionListener(btnListener);
		btnCancle.addActionListener(btnListener);
		
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
				//判断身份是否为空
				String result = "";
				for(JRadioButton rdo : rboType){
					if(rdo.isSelected()){
						result = rdo.getText();
						break;
					}
				}
				if(result.equals("")){
					JOptionPane.showMessageDialog(null, "请选择身份！");
					return;
				}
				//判断用户是否存在
				int id = Integer.parseInt(txtName.getText().toString().trim());
				if(result.equals("学生")){
					Student stu = stuDao.findStuByStuid(id);
					if(stu != null){
						//判断密码是否正确
						if(pwd.equals(stu.getPwd())){
							loginStu = stu;
							//登陆成功，进入主界面
							StuMainFrame frm = new StuMainFrame(LoginFrame.this);
							frm.setVisible(true);
							//关闭登陆界面
							LoginFrame.this.dispose();
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
				else{
					Teacher tea = teaDao.findTeacherBytId(id);
					if(tea != null){
						//判断密码是否正确
						if(pwd.equals(tea.getPwd())){
							loginTea = tea;
							//登陆成功，进入主界面
							TeaMainFrame frm = new TeaMainFrame(LoginFrame.this);
							frm.setVisible(true);
							//关闭登陆界面
							LoginFrame.this.dispose();
							
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
			}
			//取消
			else{
				LoginFrame.this.dispose();
			}
			
		}
		
	}
	

	/**
	 * 初始化组件
	 */
	public void initComponent(){
		lblTitle  = new JLabel("在线考试系统");
		lblTitle.setFont(new Font("宋体", Font.PLAIN, 30));
//		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblName = new JLabel("用户名");
		lblPassword = new JLabel("密码");
		lblType = new JLabel("身份");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("登录");
		btnCancle = new JButton("取消");
		type = new String[]{"学生","教师"};
		rboType = new JRadioButton[type.length];
		group = new ButtonGroup();
		
		//设置组件的大小和位置
		lblTitle.setBounds(100, 20, 300, 40);
		lblName.setBounds(100, 80, 40, 20);
		lblPassword.setBounds(100, 120, 40, 20);
		lblType.setBounds(100, 160, 40, 20);
		txtName.setBounds(150, 80, 140, 20);
		txtPassword.setBounds(150, 120, 140, 20);
		for(int i = 0 , x = 150; i < type.length; i++ , x += 80){
			rboType[i] = new JRadioButton(type[i]);
			group.add(rboType[i]);
			rboType[i].setBounds(x, 160, 80, 20);
			this.add(rboType[i]);
		}
		btnLogin.setBounds(120, 220, 60, 20);
		btnCancle.setBounds(210, 220, 60, 20);
		
		this.add(lblTitle);
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblType);
		this.add(txtName);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(btnCancle);	
	}

	/**
	 *  窗体初始化
	 */
	private void initFrame(){
		this.setSize(400, 330);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("登录界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置为null布局
		this.setLayout(null);
		this.setResizable(false);	
	}

	
	
	public Student getLoginStu() {
		return loginStu;
	}

	

	public Teacher getLoginTea() {
		return loginTea;
	}

	

}
