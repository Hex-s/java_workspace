package com.niit.component;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ʵ����������Ч��
 * @author Administrator
 *
 */
public class PanelBorder extends JFrame {
	private JPanel pnl;
	
	public PanelBorder(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		pnl = new JPanel();
		pnl.setBounds(50, 50, 300, 300);
		//�������ı߿�
		pnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "�ҵı���"));
		this.add(pnl);
	}
	
	public static void main(String[] args) {
		PanelBorder frm = new PanelBorder();
		frm.setVisible(true);
	}

}
