import java.util.Scanner;


public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//整数取余
//		int num1 = 10;
//		int num2 = 3;
//		int result = num1 % num2;
//		System.out.println(result);
		
		
		//键盘输入小时数，显示多少天剩余多少小时
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入小时数");
//		int hour = sc.nextInt();
//		int day = hour / 24;
//		int lastHour = hour % 24;
//		System.out.println("一共是有"+day+"天，剩余"+lastHour+"个小时");
		
		
		//键盘接收一个千位数，分别通过4个变量分别描述千位数，百位数，十位数以及个位数
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个千位数：");
		int num = sc.nextInt();
		int n1 = num % 10;
		int n2 = num / 10 % 10;
		int n3 = num / 100 % 10;
		int n4 = num / 1000;
	}

}
