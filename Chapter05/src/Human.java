import java.util.Random;
import java.util.Scanner;

/**
 * 人类，该类描述人类所具备的通用属性和方法
 * @author Administrator
 *
 */
public class Human {
	
	/***************在类中只能写属性和方法******************/
	//编写属性,属性又称为全局变量，也可以称为成员变量
	//类的属性存在默认值
	//String的默认值是null
	//int的默认值是0
	//double的默认值是0.0
	//boolean的默认值是false
	//姓名
	String name = "tom";
	//性别
	char sex = '男';
	//年龄
	int age = 20;
	
	//方法由访问修饰符，返回值类型，方法名，参数列表以及方法体构成
	/**
	 * 打印显示自我信息的方法
	 */
	public void details(){
		//定义局部变量
		String name = "jack";
		//this关键字代表当前类的实例对象
		System.out.println("我的姓名是："+this.name+",性别："+sex+",今年"+age);
//		if(true){}
//		while(true){}
	}
	
	/**
	 * 面试的方法
	 */
	public void interView(){
		//方法内部的变量又称为局部变量
//		String str = "方法内的变量";
//		System.out.println(str);
		
		//访问ClassA类的方法，由于ClassA是另一个类，因此需要进行实例化
		ClassA a = new ClassA();
		a.testMethod();
		//先自我介绍
		//方法最大的作用就是复用代码，在类的内部允许直接访问自己的方法，不需要实例化对象
		details();
		//进行面试的其他环节
		System.out.println("面试的其他环节");
	}
	
	/**
	 * 一个方法只能有一个返回值
	 * @return
	 */
	public String shopping(){
		System.out.println(name+"进行了购物");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你想购买的商品名称：");
		String str = sc.next();
		//如果定义时要求返回String类型的结果，则必须通过return关键字范围相应数据类型的值
		return str;
	}
	
	/**
	 * 从代理商处购买商品
	 * @return 返回了购买的商品对象
	 */
	public Ware shopping(Proxyer proxyer){
		System.out.println(name+"正在从"+proxyer.band+"处购买了商品");
		return proxyer.ware;
	}
	

}
