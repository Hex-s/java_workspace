//导入Random
//import java.util.Random;
import java.util.*;

public class Exam7 {

	/**
	 * 随机数
	 * @param args
	 */
	public static void main(String[] args) {
		
		/****************获取方式一****************/
		//创建产生随机数的对象
		//Random random = new Random();
		//获取随机数,参数表示种子数，代表着0-种子值的范围
		//int num = random.nextInt(5);
		//System.out.println(num);
		
		/****************获取方式二****************/
		//Math获取的是0-1的double值
		//double num = Math.random();
		//System.out.println(num);
		
		
		//产生一个0-10的随机数
		Random random = new Random();
//		int num = random.nextInt(11);
//		//创建键盘接收对象
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入你猜的数：(0-10)，偷偷的告诉你是"+num+"哦");
//		int guessNum = sc.nextInt();
//		//将猜的值和系统产生的随机数进行比较
//		if(guessNum == num){
//			System.out.println("恭喜你猜对了！");
//		}
//		else{
//			System.out.println("很遗憾，你没有猜对！");
//		}
		
		//如何产生一个1-6的随机数
//		int luckyNum = random.nextInt(6)+1;
		//使用Math产生0-9的值
		//int luckyNum = (int)(Math.random()*10);
		//使用Math产生1-6的随机数
//		int luckyNum = (int)(Math.random()*6)+1;
//		System.out.println(luckyNum);
		//产生100-1000的随机数如何产生？
		
		
	}

}
