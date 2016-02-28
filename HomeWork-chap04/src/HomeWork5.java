/**
 * 5. 旅行社团队票有优惠活动，限额10人团队（必须报满人数才有优惠活动，人数不满则团队比例优惠活动无效），
 * 如果团队中老年人比例占到70%团队票可以打5折，儿童比例达到50%打3折，其余情况不打折，
 * 海南游11-2月份打3折，三亚5，6，7和10月打5折，其余景点不打折。
 *  通过键盘录入相关信息，按#退出录入，最终求该团队的旅行票价是多少
 *  年龄>=60 老年人
 *  年龄<=12岁 为儿童
 *  初始票价500
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork5 {

	public static void main(String[] args) {
		// 老年人数
		int oldNum = 0;
		// 小孩人数
		int childNum = 0;
		// 总人数
		int totalNum = 0;
		// 票价
		double ticketPrice = 500;
		//总票价
		double totalPrice;
		//旅游地点
		String travelPlace;
		//旅游月份
		int travelMonth;
		// 成员年龄
		Scanner sc = new Scanner(System.in);
		String ageStr;
		int age;
		//获取旅游地点
		System.out.print("请输入旅游地点：");
		travelPlace = sc.next();
		//获取旅游地点
		System.out.print("请输入月份：");
		travelMonth = sc.nextInt();
		while (true) {
			System.out.print("请输入游客年龄：");
			// 输入年龄
			ageStr = sc.next();
			//输入#时便输入结束
			if (!ageStr.equals("#")) {
				// 人数加1
				totalNum++;
				// 将年龄转化成整形
				age = Integer.parseInt(ageStr);
				// 老年人数
				if (age >= 70) {
					oldNum++;
				}
				// 儿童人数
				else if (age <= 12) {
					childNum++;
				}
			}
			else{
				break;
			}
		}
		System.out.println("旅游地点为："+travelPlace+"，月份为："+travelMonth+"，团队总人数为："+totalNum + "，老年人数为：" + oldNum + "，儿童人数为：" + childNum);
		//判断旅游地点是否为海南
		if(travelPlace.equals("海南")){
			switch(travelMonth){
			case 11 :
			case 12 :
			case 1:
			case 2:
				ticketPrice *= 0.3;
			}
		}
		//判断旅游地点是否为三亚
		else if(travelPlace.equals("三亚")){
			switch(travelMonth){
			case 5 :
			case 6 :
			case 7:
			case 10:
				ticketPrice *= 0.5;
			}
		}
		//判断人数是否满10人
		//人数满10人
		if(totalNum >= 10){
			//老年人数比例
			double rate =(double) oldNum / totalNum;
			if(rate >= 0.7){
				ticketPrice *= 0.5; 
			}
			//儿童人数比例
			rate = (double) childNum / totalNum;
			if(rate >= 0.5){
				ticketPrice *= 0.3; 
			}
		}
		//总票价
		totalPrice = totalNum * ticketPrice; 
		System.out.println("总票价为："+totalPrice+"元");
	}

}
