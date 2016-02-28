/**
 * 机票购买分为经济舱和商务舱，
 * 每年的1，2，5，10，12月为旺季，其余月份为淡季，
 * 旺季的时候2,5,10月不打折，其余时间为8折，
 * 淡季的时候机票统一打4折。
 * 经济舱的价格为原价的80%，商务舱为原价的200%，
 * 要求键盘输入机票原价，购买的舱位类别和月份时间，求机票的最终价格
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 声明变量
		String space1 = "经济舱";
		String space2 = "商务舱";
		double finalPrice = 0;

		Scanner sc = new Scanner(System.in);
		// 输入机票原价
		System.out.print("请输入机票原价：");
		double originalPrice = sc.nextDouble();
		// 输入购买的舱位类型
		System.out.print("请输入购买的舱位类型为（经济舱或商务舱）：");
		String space = sc.next();
		// 输入购买的月份
		System.out.print("请输入购买的月份：");
		int month = sc.nextInt();

		// 经济舱的价格为原价的80%，商务舱为原价的200%，
		if (space.equals(space1)) {
			finalPrice = originalPrice * 0.8;
		} else {
			finalPrice = originalPrice * 2;
		}

		switch (month) {
		case 1:
		case 12:
			finalPrice*=0.8;
			break;
		case 3:
		case 4:
		case 6:
		case 7:
		case 8:
		case 9:
		case 11:
			finalPrice*=0.4;
			break;
		}
		
		//输出结果
		System.out.print("您购买的"+month+"月的"+space+"的价格为"+finalPrice+"元");

	}

}
