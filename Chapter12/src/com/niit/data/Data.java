package com.niit.data;

import java.util.ArrayList;

import com.niit.bean.User;

public class Data {

	private ArrayList<User> userData;
	
	public Data(){
		userData = new ArrayList<User>();
		userData.add(new User(1, "admin", "0000"));
	}

	public ArrayList<User> getUserData() {
		return userData;
	}
	
}
