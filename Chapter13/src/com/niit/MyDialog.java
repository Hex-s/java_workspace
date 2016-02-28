package com.niit;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 自定义对话框
 * @author Administrator
 *
 */
public class MyDialog extends JDialog {

	private JLabel lblIcon;
	private JLabel lblMsg;
	private JButton[] btns;
	private JPanel pnlTop;
	private JPanel pnlBottom;
	private int index;
	
	public MyDialog(Component parentComponent,Object message,String title,int optionType, int messageType, Icon icon,Object[] options, Object initalValue){
		super(new JFrame(), true);
		this.setLocationRelativeTo(parentComponent);
		this.setSize(400, 140);
		this.setTitle(title);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent(message, icon, options, initalValue);
		//绑定按钮的监听器
	}
	/**
	 * 初始化
	 * @param message
	 * @param icon
	 * @param options
	 * @param initalValue
	 */
	private void initComponent(Object message,Icon icon,Object[] options, Object initalValue){
		//初始化面板
		pnlTop = new JPanel();
		pnlTop.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		pnlBottom = new JPanel();
		//初始化标签
		lblIcon = new JLabel(icon);
		lblMsg = new JLabel(message.toString());
		//创建监听器
		ButtonListener listener = new ButtonListener();
		//初始化按钮
		btns = new JButton[options.length];
		for(int i = 0; i < btns.length; i++){
			btns[i] = new JButton(options[i].toString());
			pnlBottom.add(btns[i]);
			//绑定监听器
			btns[i].addActionListener(listener);
		}
		pnlTop.add(lblIcon);
		pnlTop.add(lblMsg);
		this.add(pnlTop,BorderLayout.NORTH);
		this.add(pnlBottom);
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取事件源按钮对象
			JButton btn = (JButton)e.getSource();
			//判断点击的按钮
			for(int i = 0; i < btns.length; i++){
				if(btns[i] == btn){
					//记录当前被点击按钮所在数组中的索引
					index = i;
					break;
				}
			}
			//关闭对话框
			MyDialog.this.dispose();
		}
		
	}
	
	public int getResultOption(){
		return index;
	}
}
