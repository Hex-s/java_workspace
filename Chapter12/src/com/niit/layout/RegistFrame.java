package com.niit.layout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	
	public RegistFrame(){
		//窗体设置
		this.setTitle("用户注册");
		this.setLocation(400, 100);
		this.setSize(400, 500);
		//空布局
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
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
		for(int i = 1970; i <= 2050; i++){
			cboYear.addItem(i);
		}
		//添加月份
		for(int i = 1; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//添加日期
		for(int i = 1; i <= 30; i++){
			cboDay.addItem(i);
		}
		//设置年月日的大小和位置
		cboYear.setBounds(130, 330, 60, 20);
		cboMonth.setBounds(210, 330, 40, 20);
		cboDay.setBounds(270, 330, 40, 20);
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
	
}
