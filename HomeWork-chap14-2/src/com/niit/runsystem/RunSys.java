package com.niit.runsystem;

import com.niit.data.Data;
import com.niit.ui.LoginFrame;

public class RunSys {
	
	public static void main(String[] args) {
		//ʵ��������
		Data data = new Data();
		//ʵ������¼����
		LoginFrame log = new LoginFrame(data);
		log.setVisible(true);
	}

}
