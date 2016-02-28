package com.niit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 * 继承自内部窗体类
 * @author Administrator
 *
 */
public class TestFrame extends JInternalFrame {

	public TestFrame(){
		this.setTitle("在线考试");
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
