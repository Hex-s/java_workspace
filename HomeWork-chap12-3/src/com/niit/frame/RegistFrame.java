 package com.niit.frame;

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
	private ButtonGroup group;
	private JRadioButton[] rdoSex;
	private String[] sexArray;
	private JCheckBox[] chkHobby;
	private String[] hobbyArray;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JComboBox cboDay;
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
		//年月日下拉菜单监听器
		CboDaysListener cbodaysLintener = new CboDaysListener();
		cboMonth.addItemListener(cbodaysLintener);
		
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
		this.setLocation(400, 100);
		this.setSize(400, 500);
		//空布局
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){ 
		//实例化标签
		lbls = new JLabel[6];
		lblArray = new String[]{"用户名","密码","确认密码","性别","兴趣爱好","出生日期"};
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
		//单选按钮
		group = new ButtonGroup();
		rdoSex = new JRadioButton[2];
		sexArray = new String[]{"男","女"};
		for(int i = 0, x = 130; i < rdoSex.length; i++, x+=60){
			rdoSex[i] = new JRadioButton(sexArray[i]);
			//设置大小位置
			rdoSex[i].setBounds(x, 210, 40, 20);
			//添加至按钮组
			group.add(rdoSex[i]);
			//添加至窗体
			this.add(rdoSex[i]);
		}
		//复选框
		chkHobby = new JCheckBox[4];
		hobbyArray = new String[]{"游戏","音乐","运动","睡觉"};
		for(int i = 0, x = 130, y = 270; i < chkHobby.length; i++, x+=80){
			chkHobby[i] = new JCheckBox(hobbyArray[i]);
			//判断是否是第三个复选框
			if(i == 2){
				x = 130;
				y+=30;
			}
			chkHobby[i].setBounds(x, y, 60, 20);
			this.add(chkHobby[i]);
		}
		//下拉列表框
		cboYear = new JComboBox();
		cboMonth = new JComboBox();
		cboDay = new JComboBox();
		//添加年份
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		for(int i = 1970; i <= year; i++){
			cboYear.addItem(i);
		}
		//添加月份
		for(int i = 1; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//添加日期
		for(int i = 1; i <= 31; i++){
			cboDay.addItem(i);
		}
		//设置年月日的大小和位置
		cboYear.setBounds(130, 330, 60, 20);
		cboMonth.setBounds(210, 330, 40, 20);
		cboDay.setBounds(270, 330, 45, 20);
		this.add(cboYear);
		this.add(cboMonth);
		this.add(cboDay);
		
		//按钮
		btnRegist = new JButton("注册");
		btnClose = new JButton("关闭");
		btnRegist.setBounds(130, 400, 70, 25);
		btnClose.setBounds(220, 400, 70, 25);
		this.add(btnRegist);
		this.add(btnClose);
		
	}
	
	/**
	 * 下拉列表中的day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选中项
			if(e.getStateChange() == ItemEvent.SELECTED){
				//将日中的数据清空
				cboDay.removeAllItems();
				//获取选中的年
				int year =(Integer) cboYear.getSelectedItem();
				//获取选中的月
				int month =(Integer)cboMonth.getSelectedItem();
//				System.out.println(year+" "+month);
				//添加日期
				int days = daysInMonth(year, month);
//				System.out.println(days+"天");
				for(int i = 1; i <= days; i++){
					cboDay.addItem(i);
				}
			}
		}
		
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
				//判断性别单选按钮是否被选择
				for(int i = 0; i < rdoSex.length; i++){
					if(rdoSex[i].isSelected()){
						isSelected = true;
						break;
					}
				}
				if(isSelected == false){
					JOptionPane.showMessageDialog(null, "请选择性别！");
					return;
				}
				//判断兴趣复选框是否被选择
				isSelected = false;
				for(int i = 0; i < chkHobby.length; i++){
					if(chkHobby[i].isSelected()){
						isSelected = true;
					}
				}
				if(isSelected == false){
					JOptionPane.showMessageDialog(null, "请选择您的兴趣爱好！");
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
		}
		
	}
	
	/**
	 * 获取当年当月的天数
	 * @param year
	 * @param month
	 * @return
	 */
	private int daysInMonth(int year,int month){
		int days = 0;
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		default:
			days = 31;	
		}
		return days;
	}
	
}
