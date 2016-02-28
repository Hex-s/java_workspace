//导入Scanner所在的java包
//只导入Scanner类型
import java.util.Scanner;
//将java.util包中的所有数据类型都导入
//import java.util.*;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建键盘接收对象
		Scanner sc = new Scanner(System.in);
		//接收键盘的输入的字符串
		System.out.println("请输入姓名：");
		String str = sc.next();
		System.out.println("请输入年龄");
		int age = sc.nextInt();
		System.out.println("请输入身高（单位:米）");
		double d = sc.nextDouble();
		System.out.println("请输入性别(true表示男 false表示女)");
		boolean flag = sc.nextBoolean();
		//打印显示输入的内容
		System.out.println("键盘输入的内容是："+str);
	}

}
