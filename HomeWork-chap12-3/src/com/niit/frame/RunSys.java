package com.niit.frame;

import com.niit.data.Data;

public class RunSys {
	
	public static void main(String[] args) {
		//ʵ��������
		Data data = new Data();
		//ʵ������¼����
		LoginFrame log = new LoginFrame(data);
		log.setVisible(true);
	}

}
