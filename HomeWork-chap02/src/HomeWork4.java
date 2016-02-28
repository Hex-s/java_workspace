/**
 * 4. 键盘接受一个单精度浮点类型，并将该类型进行装箱，转换成字符串类型
 * 5. 将上题中的字符串类型转换成双精度浮点包装类型，进行拆箱后再转换成整型
 *
 */

import java.util.Scanner;
public class HomeWork4 {
	
	public static void main(String[] args){
		//从键盘接受一个单精度浮点类型
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入一个单精度浮点类型数：");
		float n1=sc.nextFloat();
		//对float进行装箱
		Float n2=new Float(n1);
		//转换成字符串类型
		String str =n2.toString();
		//输出转换的结果
		System.out.println("单精度类型数转换成字符串类型："+str);
		
		//将字符串类型转换成双精度浮点数
		double n3=Double.parseDouble(str);
		System.out.println("将字符串类型转换成双精度浮点数："+n3);
		//对double进行包装
		Double n4=new Double(n3);
		//对double进行拆箱
		double n5=n4.doubleValue();
		//将double转换成整型
		int n6=(int)n5;
		System.out.print("将双精度浮点类型转换成整型："+n6);
	}

}
