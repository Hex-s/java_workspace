package com.niit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 * �̳����ڲ�������
 * @author Administrator
 *
 */
public class TestFrame extends JInternalFrame {

	public TestFrame(){
		this.setTitle("���߿���");
		this.setBounds(200, 200, 400, 400);
		this.setClosable(true);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void doDefaultCloseAction() {
		// TODO Auto-generated method stub
		//super.doDefaultCloseAction();
		this.dispose();
	}
	
	
}
