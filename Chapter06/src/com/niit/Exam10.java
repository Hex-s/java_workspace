package com.niit;

public class Exam10 {
	
	public void change(StringBuffer buffer1,StringBuffer buffer2,StringBuffer buffer3){
		buffer1 = new StringBuffer("AA");
		buffer2.append("B");
		buffer3 = buffer1;
		buffer3.append("C");
		
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		StringBuffer buffer1= new StringBuffer("A");
		StringBuffer buffer2= new StringBuffer("B");
		StringBuffer buffer3= new StringBuffer("C");
		Exam10 ex = new Exam10();
		ex.change(buffer1, buffer2, buffer3);
		System.out.println(buffer1);
		System.out.println(buffer2);
		System.out.println(buffer3);
		
	}
}
