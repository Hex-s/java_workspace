package com.niit.frame;

import com.niit.data.Data;

public class RunSys {
	
	public static void main(String[] args) {
		//实例化数据
		Data data = new Data();
		//实例化登录界面
		LoginFrame log = new LoginFrame(data);
		log.setVisible(true);
	}

}
