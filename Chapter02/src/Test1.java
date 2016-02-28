
import java.util.Scanner;
public class Test1 {

	/**
	 * 使用键盘接收今天的星期数，天气的温度，今天所处的年月日，所穿衣服的颜色，自己的体重单位g
     * 使用变量接收输入的结果，并将所有变量内容打印呈现
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("今天是星期几：");
		String week = sc.next();
		
		System.out.println("今天的温度：");
		int tempeture = sc.nextInt();
		
		System.out.println("今天所处的年月日：");
		String date = sc.next();
		
		System.out.println("衣服的颜色：");
		String clothColor = sc.next();
		
		System.out.println("体重（单位为g）");
		int weight=sc.nextInt();
		
		System.out.println("今天是"+week+"，温度是"+tempeture+"℃,日期是"+date+",衣服的颜色是"+clothColor+",体重为"+weight+"g");

	
	}

}
