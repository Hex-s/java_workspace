package com.niit;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * 选项卡面板
 * @author Administrator
 *
 */
public class Exam7 extends JFrame{

	//选项卡又称为叶卡面板
	private JTabbedPane tabPnl;
	//面板
	private JPanel pnlRed;
	private JPanel pnlYellow;
	private JPanel pnlOrange;
	
	/**
	 * 
	 */
	public Exam7(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//实例化选项卡面板
		//tabPnl = new JTabbedPane();
		//第一个参数表示选项卡按钮的呈现位置，第二个参数表示选项卡的布局策略WRAP_TAB_LAYOUT,SCROLL_TAB_LAYOUT
		tabPnl = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//实例化面板
		pnlOrange = new JPanel();
		pnlOrange.setBackground(Color.orange);
		pnlRed = new JPanel();
		pnlRed.setBackground(Color.red);
		pnlYellow = new JPanel();
		pnlYellow.setBackground(Color.yellow);
		//为选项卡面板添加每一页内容
		tabPnl.add("red", pnlRed);
		tabPnl.add("orange",pnlOrange);
		tabPnl.add("yellow",pnlYellow);
		
		//设置默认的选中项
		//tabPnl.setSelectedIndex(2);
		//通过面板设置
		tabPnl.setSelectedComponent(pnlOrange);		
		//绑定监听器
		tabPnl.addChangeListener(new TabbenPaneListener());
		
		
		this.add(tabPnl);
	}
	/**
	 * 选项卡监听器
	 * @author Administrator
	 *
	 */
	private class TabbenPaneListener implements ChangeListener{

		/**
		 *  选项变更时会触发
		 */
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			//获取选中项的索引
			//JOptionPane.showMessageDialog(null, tabPnl.getSelectedIndex());
			//获取选中的面板
			JOptionPane.showMessageDialog(null, tabPnl.getSelectedComponent().getBackground());
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam7 frm = new Exam7();
		frm.setVisible(true);
	}

}
