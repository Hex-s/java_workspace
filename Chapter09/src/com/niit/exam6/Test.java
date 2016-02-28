package com.niit.exam6;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICommon common;
		
		//∂‡Ã¨–‘
		//common = new BaseA();
		//common = new BaseB();
		
//		BaseA baseA = new ChildA();
//		BaseB baseB = new ChildB();
		
//		common = new ChildA();
//		common = new ChildB();
		
		common = new ClassA();
		
		IOtherA otherA = new ClassB();
		IOtherB otherB = new ClassB();
		common = new ClassB();
	}

}
