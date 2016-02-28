package com.niit;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.FeatureDescriptor;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * 各个组件的使用
 * @author Administrator
 *
 */
public class ComponentExam1 extends JFrame {
	
	//窗体中添加的组件都应写成属性
	//标签 用于在窗体呈现静态信息
	private JLabel lbl;
	//文本框
	private JTextField txtName;
	//密码框
	private JPasswordField txtPwd;
	//下拉列表框
	private JComboBox cboCourse;
	//单选按钮
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;
	//一组单选按钮为了便于循环操作可以写成数组
	private JRadioButton[] rdoSex;
	private String[] sexArray;
	//复选框
	private JCheckBox[] chkHobby;
	private String[] hobbyArray;
	//按钮
	private JButton btnPress;
	//按钮组
	private ButtonGroup group;
	//面板  容器组件
	private JPanel pnlContainer;
	
	public ComponentExam1(){
		
		//初始化窗体
		setBounds(400, 200, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setBackground(Color.orange);
		//修改窗体的布局方式
		setLayout(new FlowLayout());
		
		/***********************JLable*************************/
		//实例化标签
		//lbl = new JLabel();
//		//设置标签的文字内容
		//lbl.setText("用户名");
//		//获取标签设置的内容
//		//System.out.println(lbl.getText());
//		//设置图片,图片文件夹放置在项目的跟路径中
//		ImageIcon imageIcon = new ImageIcon("image/back.jpg");
//		//设置图片的大小   先将ImageIcon转换成Image对象，再对其大小进行重绘
//		Image image = imageIcon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
//		//再将Image转换成ImageIcon
//		imageIcon = new ImageIcon(image);
//		lbl.setIcon(imageIcon);
		//设置标签文字的水平对齐方式
		//lbl.setHorizontalAlignment(JLabel.LEFT);
		
		/***********************JTextField*************************/
//		txtName = new JTextField();
//		//设置文本框的列数
//		txtName.setColumns(10);
//		//设置文本框的默认值
//		txtName.setText("默认值");
//		//获取文本框内写入的值
//		System.out.println(txtName.getText());
		
		/***********************JPasswordField*************************/
//		txtPwd = new JPasswordField();
//		txtPwd.setColumns(20);
//		//设置默认密码值
//		txtPwd.setText("tom's password");
//		//获取密码值
//		//System.out.println(txtPwd.getText());
//		String pwd = new String(txtPwd.getPassword());
//		System.out.println(pwd);
//		//设置密码框呈现的字符
//		txtPwd.setEchoChar('$');
		
		/***********************JComboBox*************************/
		//空参构建
//		cboCourse = new JComboBox();
		//添加选项
//		cboCourse.addItem("html");
//		cboCourse.addItem("java");
//		cboCourse.addItem("oracle");
//		cboCourse.addItem("JDBC");
		//获取选项
		//直接获取选项的值
//		Object value = cboCourse.getSelectedItem();
		//获取选中项的索引
//		int index = cboCourse.getSelectedIndex();
//		System.out.println(index);
//		Object value = cboCourse.getItemAt(index);
//		System.out.println(value);
		//获取选项的数量
//		System.out.println(cboCourse.getItemCount());
		//设置默认选项
//		cboCourse.setSelectedIndex(2);
		//移除选项
		//cboCourse.removeItem("oracle");
		//cboCourse.removeItemAt(2);
		
		//通过数组构建
		//cboCourse = new JComboBox(new String[]{"A","B","C","D"});
		
		//通过集合构建
//		Vector<String> vector = new Vector<String>();
//		vector.add("A");
//		vector.add("B");
//		cboCourse = new JComboBox(vector);
		
		//通过模型构建
		//创建模型对象
//		DefaultComboBoxModel model = new DefaultComboBoxModel();
//		cboCourse = new JComboBox(model);
//		//使用模型构建，所有操作都应基于模型对象来实现
//		//添加元素
//		model.addElement("A");
//		model.addElement("B");
//		//移除元素
//		model.removeElementAt(0);

		/***********************JRadioButton*************************/
//		rdoMale = new JRadioButton("男");
//		rdoFemale = new JRadioButton("女");
//		//要实现互斥必须将单选按钮添加至同一个组别中
//		//按钮组不属于swing的组件
//		group = new ButtonGroup();
//		group.add(rdoMale);
//		group.add(rdoFemale);
//		//设置默认选中的按钮
//		rdoFemale.setSelected(true);
		//获取选中的项 通过判断每个按钮的选中状态来获取
//		if(rdoMale.isSelected()){
//			System.out.println("选中项是男");
//		}
//		else if(rdoFemale.isSelected()){
//			System.out.println("选中项是女");
//		}
		
		//添加按钮
//		this.add(rdoMale);
//		this.add(rdoFemale);
		
		//通过遍历容器中的组件来判断是否选中
//		for(Component component : this.getContentPane().getComponents()){
//			//判断组件是否是单选按钮类型
//			if(component instanceof JRadioButton){
//				//拆箱成JRadioButton
//				JRadioButton rdo = (JRadioButton)component;
//				//判断是否选中
//				if(rdo.isSelected()){
//					System.out.println(rdo.getText());
//					break;
//				}
//			}
//		}
		
		//使用数组操作单选按钮
//		rdoSex = new JRadioButton[2];
//		sexArray = new String[]{"male","female"};
//		//循环构建单选按钮
//		for(int i = 0; i < rdoSex.length; i++){
//			rdoSex[i] = new JRadioButton(sexArray[i]);
//			//添加至按钮组
//			group.add(rdoSex[i]);
//			//添加至窗体
//			this.add(rdoSex[i]);
//		}
//		//默认选中项
//		rdoSex[1].setSelected(true);
//		//获取选中的项
//		String result = "";
//		for(JRadioButton rdo : rdoSex){
//			//判断是否选中
//			if(rdo.isSelected()){
//				result = rdo.getText();
//				break;
//			}
//		}
//		System.out.println("选中项是："+result);
		
		
		/***********************JCheckBox*************************/
//		chkHobby = new JCheckBox[4];
//		hobbyArray = new String[]{"Game","Music","Sprort","Sleep"};
//		//循环构建复选框
//		for(int i = 0; i < chkHobby.length; i++){
//			chkHobby[i] = new JCheckBox(hobbyArray[i]);
//			//添加至窗体
//			this.add(chkHobby[i]);
//		}
//		//设置默认选中项
//		chkHobby[0].setSelected(true);
		
		
		/***********************JButton*************************/
		//按钮可以呈现文字和图片
		btnPress = new JButton("press");
		//获取按钮上的文本值
		//btnPress.getText();
		
		/***********************JPanel*************************/
		pnlContainer = new JPanel();
		//将按钮添加至面板
		pnlContainer.add(btnPress);
		//将面板添加至窗体，同时面板中的组件也会随之加到窗体中
		this.add(pnlContainer);
		//添加一个复选框
		//pnlContainer.add(new JCheckBox("A"));
		
		pnlContainer.setBackground(Color.orange);
		
		//将标签添加至窗体
		//this.add(lbl);
		//this.add(txtName);
		//this.add(txtPwd);
		//this.add(cboCourse);
		//this.add(btnPress);
		
	}
	
	public static void main(String[] args) {
		//将窗体实例化
		ComponentExam1 frm = new ComponentExam1();
		//呈现窗体
		frm.setVisible(true);
	}
}
