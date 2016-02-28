package com.niit.test;

import com.niit.data.Data;
import com.niit.usedcar.SearchCar;

	public class RunSystem {
		
		public static void main(String[] args) {
			Data data = new Data();
			SearchCar frm = new SearchCar(data);
			frm.setVisible(true);
		}


}
