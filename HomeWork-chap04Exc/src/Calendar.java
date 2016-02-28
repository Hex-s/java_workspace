import java.util.Scanner;

public class Calendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 输入年份
		System.out.print("请输入年份（>=1900）：");
		int year = sc.nextInt();
		// 输入月份
		System.out.print("请输入月份：");
		int month = sc.nextInt();
		// 总天数
		int totalDays = 0;
		// 1990-year的累积天数
		for (int i = 1900; i < year; i++) {
			// 判断该年是否为闰年
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		// 1月到输入月的天数
		// 每月的天数
		int day = 0;
		for (int i = 1; i <= month; i++) {
			switch (i) {
			// 判断当年是否为闰年
			case 2:
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					day = 29;
				} else {
					day = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			default:
				day = 31;
				break;
			}
			//累加1月到输入月的天数
			if(i < month ){
			totalDays += day;}
		}
		//判断每月的第一天是星期几
		int week = (totalDays + 1) % 7;
		//输出星期数
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		//输出1号前的空格
		for(int i = 1; i <= week; i++){
			System.out.print("\t");
		}
		//打印当前月份的每一天
		for(int i = 1;i <= day; i++){
			System.out.print(i+"\t");
			if((totalDays+i) % 7 == 6){
				System.out.println();
			}
		}
		
	}

}
