package com.niit.exam1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//实例化各个对象
//		Water water = new Water();
//		Ice ice = new Ice();
//		Vapour vapour = new Vapour();
		
		//多态性，可以用父类接受子类的实例
		//H2O可以是水
//		H2O h1 = water;
//		//H2O可以是冰
//		H2O h2 = ice;
//		//H2O可以是水蒸气
//		H2O h3 = vapour;
		
		//多态性可以使原本单一的数据类型在不同环境中有着更强的环境适应力
		//实例化水元素
		H2O h2o = new H2O(-170);
		//水元素根据环境改变后的类型
		H2O newH2o;
		//判断水元素的温度
		//如果温度低于0度，水元素将会变成冰
		if(h2o.getTemp() < 0){
			newH2o = new Ice();
		}
		//如果温度高于100度，水元素会变成水蒸气
		else if(h2o.getTemp() > 100){
			newH2o = new Vapour();
		}
		//其余情况，在常温中水元素会变成液态的水
		else{
			newH2o = new Water();
		}
		//水元素根据环境做出的改变
		h2o = newH2o;
		//描述当前的水元素
		//当然是用多态性，用父类接受子类时，调用的方法和属性都是子类的内容
		h2o.details();
	}

}
