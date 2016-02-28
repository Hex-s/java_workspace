package com.niit.component;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class LinkLabelTestFrame extends JFrame {

	private LinkLabel lbl;
	
	public LinkLabelTestFrame(){
		this.setBounds(200, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		lbl = new LinkLabel("taobao", "http://www.taobao.com");
		this.add(lbl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkLabelTestFrame frm = new LinkLabelTestFrame();
		frm.setVisible(true);
	}

}
