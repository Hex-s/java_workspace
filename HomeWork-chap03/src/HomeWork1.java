/**
 * 1.输入一个自己生日的年份输出年份中的每一个数值
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入您的生日年份：");
		int year = sc.nextInt();
		// 获取个位数
		int n1 = year % 10;
		// 获取十位数
		int n2 = year / 10 % 10;
		// 获取百位数
		int n3 = year / 100 % 10;
		// 获取千位数
		int n4 = year / 1000;
		// 输出结果
		System.out.print("您生日年份的千位数是：" + n4 + "，百位数是：" + n3 + "，十位数是：" + n2
				+ "，个位数是：" + n1);

	}

}
