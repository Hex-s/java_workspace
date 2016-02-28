package com.niit.exam9;
/**
 * 计算工厂，该工厂对象用来生产用于计算的对象
 * @author Administrator
 *
 */
public class CalculateFactory {

	/**
	 * 根据运算符进行计算对象生产的方法
	 * @param opt
	 * @return
	 */
	public ICalculate buildInstance(String opt){
		//计算对象
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
