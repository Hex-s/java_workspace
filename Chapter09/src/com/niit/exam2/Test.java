package com.niit.exam2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//借助于多态性是用父类接受子类的实例
		Base base1 = new Child();
		Base base2 = new Base();
		Child child = new Child();
		
		//子类不能接受父类的实例
		//child = (Child)base2;
		//child.method1();
		
		//以下代码可以正确运行，因为base1的实例是子类的实例
		child = (Child)base1;
		child.method1();
		
		//装箱  在面向对象中将明确的数据类型转换成某一个父类或接口时的过程就是装箱
		Object obj = new Child();
		//拆箱  将父类或接口中的类型转换成明确的类型的过程称为拆箱
		//正确的情况，基于多态性的转换
		Base base = (Base)obj;
		base.method1();
		//错误的情况
//		AnotherChild another = (AnotherChild)obj;
//		another.method1();
		//正确的情况，obj的本身就是child实例
		Child child1 = (Child)obj;
		child1.method1();
		
		//拆箱时应先对父类的类型进行判断 答案：base:子类的第一个方法
		if(obj instanceof Base){
			Base base3 = (Base)obj;
			System.out.print("base:");
			base3.method1();
		}
		else if(obj instanceof Child){
			Child child2 = (Child)obj;
			System.out.print("child:");
			child2.method1();
		}
		
		//答案：child:子类的第一个方法
//		if(obj instanceof Child){
//			Child child2 = (Child)obj;
//			System.out.print("child:");
//			child2.method1();
//		}
//		else if(obj instanceof Base){
//			Base base3 = (Base)obj;
//			System.out.print("base:");
//			base3.method1();
//		}

			
		//对象调用的方法取决于实例的类型
		//使用多态性的时候由于父类只能访问到子类实例中同名的方法，因此在编写子类时必须要对父类的某些方法进行重写
		//base1.method1();
		//父类类型无法调用子类新增的属性及方法
		//base1.otherMethod();错误编写
		
		
		//通过反射辨识当前运行的数据类型
		//变量名 instanceof 数据类型名称
//		if(base2 instanceof Child){
//			System.out.println("这是子类的实例");
//		}
//		else if(base2 instanceof Base){
//			System.out.println("这是父类的实例");
//		}
		
	}

}
