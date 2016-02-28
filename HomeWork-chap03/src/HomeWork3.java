/**
 * 3. 输入年份和月份，判断所输月份一共有多少天
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 输入年份
		System.out.print("请输入年份：");
		int year = sc.nextInt();
		// 输入月份
		System.out.print("请输入月份:");
		int month = sc.nextInt();
		// 闰年的二月天数
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			if (month == 2) {
				System.out.print(year + "年的" + month + "月有29天");
			}
		}
		//非闰年的二月天数
		else {
			if (month == 2) {
				System.out.print(year + "年的" + month + "月有28天");
			}
		}

		// 其他月份
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.print(year + "年的" + month + "月有31天");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.print(year + "年的" + month + "月有30天");
			break;
		}
	}

}
