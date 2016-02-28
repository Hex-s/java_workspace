package com.niit.exam9;
/**
 * ���㹤�����ù������������������ڼ���Ķ���
 * @author Administrator
 *
 */
public class CalculateFactory {

	/**
	 * ������������м�����������ķ���
	 * @param opt
	 * @return
	 */
	public ICalculate buildInstance(String opt){
		//�������
		ICalculate calObj = null;
		if(opt.equals("+")){
			calObj = new Addition();
		}
		else if(opt.equals("-")){
			calObj = new Substraction();
		}
		else if(opt.equals("*")){
			calObj = new Multiplication();
		}
		else if(opt.equals("/")){
			calObj = new Divition();
		}
		return calObj;
	}
}
