package com.niit.runsystem;

import com.niit.data.Data;
import com.niit.ui.LoginFrame;

public class RunSys {
	
	public static void main(String[] args) {
		//实例化数据
		Data data = new Data();
		//实例化登录界面
		LoginFrame log = new LoginFrame(data);
		log.setVisible(true);
	}

}
