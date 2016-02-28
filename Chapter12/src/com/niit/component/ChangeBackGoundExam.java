package com.niit.component;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeBackGoundExam extends JFrame{
	
	private JPanel pnlBackground;
	private MyComboBox cboColor;
	
	public ChangeBackGoundExam(){
		
		this.setBounds(200, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		pnlBackground = new JPanel();
		pnlBackground.setBounds(20, 60, 200, 100);
		cboColor = new MyComboBox();
		cboColor.setBounds(20, 20, 100, 25);
		
		cboColor.addMyItem(new MyItem("red",Color.red));
		cboColor.addMyItem(new MyItem("yellow",Color.yellow));
		cboColor.addMyItem(new MyItem("green",Color.green));
		
		this.add(pnlBackground);
		this.add(cboColor);
		//绑定监听器
		cboColor.addItemListener(new ComboboxListener());
	}
	
	/**
	 * 监听器
	 * @author Administrator
	 *
	 */
	private class ComboboxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选中状态
			if(e.getStateChange() == ItemEvent.SELECTED){
				//根据选中项的颜色设置面板的背景色
				pnlBackground.setBackground(cboColor.getSelectedColor());
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ChangeBackGoundExam frm = new ChangeBackGoundExam();
		frm.setVisible(true);
	}
}
