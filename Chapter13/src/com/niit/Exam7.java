package com.niit;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * ѡ����
 * @author Administrator
 *
 */
public class Exam7 extends JFrame{

	//ѡ��ֳ�ΪҶ�����
	private JTabbedPane tabPnl;
	//���
	private JPanel pnlRed;
	private JPanel pnlYellow;
	private JPanel pnlOrange;
	
	/**
	 * 
	 */
	public Exam7(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ʵ����ѡ����
		//tabPnl = new JTabbedPane();
		//��һ��������ʾѡ���ť�ĳ���λ�ã��ڶ���������ʾѡ��Ĳ��ֲ���WRAP_TAB_LAYOUT,SCROLL_TAB_LAYOUT
		tabPnl = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//ʵ�������
		pnlOrange = new JPanel();
		pnlOrange.setBackground(Color.orange);
		pnlRed = new JPanel();
		pnlRed.setBackground(Color.red);
		pnlYellow = new JPanel();
		pnlYellow.setBackground(Color.yellow);
		//Ϊѡ�������ÿһҳ����
		tabPnl.add("red", pnlRed);
		tabPnl.add("orange",pnlOrange);
		tabPnl.add("yellow",pnlYellow);
		
		//����Ĭ�ϵ�ѡ����
		//tabPnl.setSelectedIndex(2);
		//ͨ���������
		tabPnl.setSelectedComponent(pnlOrange);		
		//�󶨼�����
		tabPnl.addChangeListener(new TabbenPaneListener());
		
		
		this.add(tabPnl);
	}
	/**
	 * ѡ�������
	 * @author Administrator
	 *
	 */
	private class TabbenPaneListener implements ChangeListener{

		/**
		 *  ѡ����ʱ�ᴥ��
		 */
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			//��ȡѡ���������
			//JOptionPane.showMessageDialog(null, tabPnl.getSelectedIndex());
			//��ȡѡ�е����
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
